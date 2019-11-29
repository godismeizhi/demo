package com.example.demo.annotation;

import com.example.demo.enums.RedisKey;

import java.lang.annotation.*;


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LoadCache {

    RedisKey value();
}
