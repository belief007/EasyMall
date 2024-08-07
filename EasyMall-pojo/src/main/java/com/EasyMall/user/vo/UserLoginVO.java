package com.EasyMall.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "用户登录返回的数据模型")
public class UserLoginVO implements Serializable {
    @ApiModelProperty("用户的id")
    private Long id;
    private String username;
    private String token;
}
