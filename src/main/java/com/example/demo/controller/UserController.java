package com.example.demo.controller;

import com.example.demo.common.R;
import com.example.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "用戶接口API", description = "用戶")
public class UserController {


    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer")
    @GetMapping("/users/{id}")
    public R<User> getInfo(@PathVariable("id") Integer id) {

        return R.getInstance(new User());
    }


    @GetMapping("/users")
    @ApiOperation(value = "获取用户列表信息", notes = "根据url的id来获取用户列表信息")
    public R<List<User>> getInfos() {

        List<User> users = new ArrayList<>();
        users.add(new User());
        return R.getInstance(users);
    }
}
