package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.R;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bule&fat
 * @since 2019-07-30
 */
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private IUserService userService;

    @RequestMapping("/{id}")
    public R<User> getUserInfo(){

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",1);

      return R.getInstance(userService.getOne(queryWrapper));
    }
}
