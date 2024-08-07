package com.EasyMall.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "用户登录时传递的数据模型")
public class UserLoginDTO implements Serializable {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("登录密码")
    private String password;
}
