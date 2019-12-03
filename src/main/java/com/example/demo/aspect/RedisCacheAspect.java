package com.example.demo.aspect;

import com.example.demo.annotation.LoadCache;
import com.example.demo.business.cache.RedisService;
import com.example.demo.enums.RedisKey;
import com.example.demo.util.CommonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
@Slf4j
@Order(2)
public class RedisCacheAspect {

    @Autowired
    private RedisService redisService;

    /**
     * 这里我们使用注解的形式
     * 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method
     * 切点表达式:   execution(...)
     */
    @Pointcut("@annotation(com.example.demo.annotation.LoadCache)")
    public void pointcut() {
    }

    /**
     * 环绕通知 @Around  ， 当然也可以使用 @Before (前置通知)  @After (后置通知)
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LoadCache loadCache = method.getAnnotation(LoadCache.class);

        //如果没有注解直接路过
        if (loadCache == null) {
            return joinPoint.proceed(joinPoint.getArgs());
        }

        RedisKey redisKey = loadCache.value();

        //获取参数的名和值
        Object[] args = joinPoint.getArgs(); // 参数值
        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        //构成缓存的参数只为字符串

        Map<String, Object> keyValuesMap = new HashMap<>();
        for (int i = 0; i < argNames.length; i++) {

            if (args[i] instanceof java.lang.String
                    || args[i] instanceof java.lang.Long
                    || args[i] instanceof java.lang.Integer
                    || args[i] instanceof java.lang.String
                    || args[i] instanceof java.lang.Short) {
                keyValuesMap.put(argNames[i], args[i] == null ? "" : String.valueOf(args[i]));
            } else {
                Map<String, Object> resultMap = CommonUtils.objectToMap(args[i]);
                keyValuesMap.putAll(resultMap);
            }
        }

        String redisKeyStr = RedisKey.getKey(redisKey, keyValuesMap);
        Object value = redisService.getValue(redisKeyStr);
        log.info("=============获取缓存 " + redisKey.getDescription() + "   " + redisKeyStr + " " + value);
        if (value != null) return value;

        value = joinPoint.proceed(joinPoint.getArgs());
        if (redisKey.getSeconds() != null && redisKey.getSeconds() != -1) {
            redisService.setValue(redisKeyStr, value, redisKey.getSeconds());
            log.info("=============写入缓存 " + redisKey.getDescription() + "   " + redisKeyStr
                    + " " + value + " " + redisKey.getSeconds());
        } else {
            redisService.setValue(redisKeyStr, value);
            log.info("=============写入缓存 " + redisKey.getDescription() + "   " + redisKeyStr + " " + value);
        }
        return value;
    }
}
