package com.EasyMall.controller.admin;

import com.EasyMall.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admin")
@Api(tags = "管理端用户接口")
public class AdminController {

    @GetMapping("/test")
    public String test(){
        return "hello";
    }

    @PostMapping("/login")
    @ApiOperation("管理端用户登录")
    public Result login(){

        return Result.success();
    }
}
