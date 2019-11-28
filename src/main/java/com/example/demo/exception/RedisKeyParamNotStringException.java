package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * RedisKey参数类型不正确异常
 */
@Slf4j
public class RedisKeyParamNotStringException extends Exception {

    private String keyName;

    public RedisKeyParamNotStringException(String keyName) {
        log.info("参数:" + keyName + " 不是String类型");
        this.keyName = keyName;
    }

    public String getKeyName() {
        return keyName;
    }
}
