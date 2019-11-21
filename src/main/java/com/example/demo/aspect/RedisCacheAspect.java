package com.example.demo.aspect;

import com.example.demo.annotion.LoadCache;
import com.example.demo.business.cache.RedisService;
import com.example.demo.enums.RedisKey;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class RedisCacheAspect {

    @Autowired
    private RedisService redisService;

    /**
     * 这里我们使用注解的形式
     * 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method
     * 切点表达式:   execution(...)
     */
    @Pointcut("@annotation(com.example.demo.annotion.LoadCache)")
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

        RedisKey redisKey = loadCache.redisKey();
        String[] keyValues = loadCache.keyValues();

        Object value = redisService.getValue(redisKey, keyValues);
        log.info("=============获取缓存" + redisKey.getDescription() + ":" + value);
        if (value != null) return value;

        value = joinPoint.proceed(joinPoint.getArgs());
        redisService.setValue(redisKey, keyValues, value);
        log.info("=============写入缓存" + redisKey.getDescription() + ":" + value);
        return value;
    }
}
