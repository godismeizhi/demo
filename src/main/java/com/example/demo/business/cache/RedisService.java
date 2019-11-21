package com.example.demo.business.cache;

import com.example.demo.enums.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    ValueOperations<String, Object> valueOperations;


    @PostConstruct
    public void init() {
        valueOperations = redisTemplate.opsForValue();
    }

    /**
     * 读缓存
     */
    public Object getValue(RedisKey redisKey, String... keyValues) {

        Object value = valueOperations.get(RedisKey.getKey(redisKey, keyValues));
        return value;
    }

    /**
     * 设置缓存信息
     * values包含 keyValues,value
     * 最后一个值为redis的补充value ，其他value均为key的补充参数
     *
     * @param redisKey
     */
    public void setValue(RedisKey redisKey, String[] keyValues, Object value) {

        if (redisKey.getSeconds().equals(-1)) {
            valueOperations.set(RedisKey.getKey(redisKey, keyValues), value);
        } else {
            valueOperations.set(RedisKey.getKey(redisKey, keyValues), value, redisKey.getSeconds(), TimeUnit.SECONDS);
        }
    }

    /**
     * 删除缓存
     *
     * @param redisKey
     * @param keyValues
     */
    public void deleteValue(RedisKey redisKey, String... keyValues) {
        this.deleteValue(RedisKey.getKey(redisKey, keyValues));
    }

    /**
     * 模糊匹配删除所有该对象的key
     *
     * @param key
     */
    public void deleteValue(String key) {
        redisTemplate.delete(key + "*");
    }
}
