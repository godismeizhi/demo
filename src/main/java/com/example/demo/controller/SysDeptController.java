package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.annotion.LoadCache;
import com.example.demo.common.R;
import com.example.demo.entity.SysDept;
import com.example.demo.enums.RedisKey;
import com.example.demo.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门管理 前端控制器
 * </p>
 *
 * @author bule&fat
 * @since 2019-11-28
 */
@RestController
@RequestMapping("/sysDepts")
public class SysDeptController {

    @Autowired
    private ISysDeptService sysDeptService;

    @GetMapping("/{id}")
    @LoadCache(RedisKey.DEPT_DEPTID_TO_OBJECT)
    public R<SysDept> getSysDept(@PathVariable("id") Integer id) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        return R.getInstance(sysDeptService.getOne(queryWrapper));
    }

}
