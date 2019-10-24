package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.R;
import com.example.demo.config.SysLog;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author bule&fat
 * @since 2019-08-16
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private AtomicInteger count = new AtomicInteger(0);

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    @SysLog
    public R<List<User>> getUserInfo(@PathVariable Integer id) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        queryWrapper.or();
        queryWrapper.eq("id", count.intValue());
        return R.getInstance(userService.list(queryWrapper));
    }

}
