package com.example.demo.enums;


import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public enum RedisKey {


    //渠道缓存
    USER_USERID_TO_OBJECT("USER:USER:USERID:{id}", "用户ID获取用户对象", 60),

    DEPT_DEPTID_TO_OBJECT("USER:DEPT:DEPTID:{id}", "部门ID获取部门信息", 60),
    ;

    //模板
    private String keyTemplate;

    //描述
    private String description;

    //时间
    private Integer seconds;

    RedisKey(String keyTemplate, String description, Integer seconds) {
        this.keyTemplate = keyTemplate;
        this.description = description;
        this.seconds = seconds;
    }

    RedisKey(String keyTemplate, String description) {
        this(keyTemplate, description, -1);
    }


    //获取动态参数后的redisKey
    public static String getKey(RedisKey redisKey, Map<String, Object> keyValuesMap) {

        String redisKeyResult = redisKey.getKeyTemplate();
        for (Map.Entry<String, Object> keyValue : keyValuesMap.entrySet()) {

            String replaceKey = "{" + keyValue.getKey() + "}";
            if (redisKeyResult.indexOf(replaceKey) != -1) {

                Object paramValue = keyValue.getValue();
                redisKeyResult = redisKeyResult.replace(replaceKey, paramValue == null ? "" : paramValue.toString());
            }
        }
        return redisKeyResult.trim();
    }

    public String getKeyTemplate() {
        return keyTemplate;
    }

    public void setKeyTemplate(String keyTemplate) {
        this.keyTemplate = keyTemplate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }
}
