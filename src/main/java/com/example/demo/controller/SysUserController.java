package com.example.demo.controller;


import com.example.demo.common.R;
import com.example.demo.entity.SysUser;
import com.example.demo.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author bule&fat
 * @since 2019-10-24
 */
@RestController
@RequestMapping("/users")
@Api(value = "用户管理", description = "用户管理", tags = "用户")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户信息", notes = "根据用户的id来获取用户详细信息")
    public R<SysUser> getUser(@PathVariable Integer id) {

        return R.getInstance(sysUserService.getById(id));
    }

}
