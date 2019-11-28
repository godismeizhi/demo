package com.example.demo.business.cache;

import com.example.demo.enums.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
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
    public Object getValue(String key) {

        Object value = valueOperations.get(key);
        return value;
    }

    /**
     * 设置缓存信息
     */
    public void setValue(String key, Object value, int seconds) {

        valueOperations.set(key, value, seconds, TimeUnit.SECONDS);
    }

    /**
     * 设置
     *
     * @param key
     * @param value
     */
    public void setValue(String key, Object value) {
        valueOperations.set(key, value);
    }

    /**
     * 删除缓存
     *
     * @param redisKey
     */
    public void deleteValue(RedisKey redisKey, Map<String, Object> keyValuesMap) {
        this.deleteValue(RedisKey.getKey(redisKey, keyValuesMap));
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
