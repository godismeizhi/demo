package com.example.demo.enums;


public enum RedisKey {


    //渠道缓存
    USER_USERID_TO_OBJECT("USER:USER:USERID:{USERID}", "渠道名称获取渠道ID", 300),
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
    public static String getKey(RedisKey redisKey, String... values) {

        String redisKeyResult = redisKey.getKeyTemplate();
        for (int i = 0; i < values.length; i++) {
            redisKeyResult = redisKeyResult.replace("{" + i + "}", values[i]);
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
