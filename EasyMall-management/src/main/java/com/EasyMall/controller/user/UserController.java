package com.EasyMall.controller.user;

import com.EasyMall.constant.JwtClaimsConstant;
import com.EasyMall.constant.MessageConstant;
import com.EasyMall.properties.JwtProperties;
import com.EasyMall.result.Result;
import com.EasyMall.ums.UserService;
import com.EasyMall.user.dto.UserLoginDTO;
import com.EasyMall.user.dto.UserRegisterDTO;
import com.EasyMall.user.entity.User;
import com.EasyMall.user.vo.UserLoginVO;
import com.EasyMall.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户端用户接口")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 用户登录接口
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口")
    public Result login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("用户登录：{}",userLoginDTO);
        //TODO 用户登录的使用不同的登录方式如：(username and password) or (phoneNumber and code) or (email and code)
        User user = userService.login(userLoginDTO);

        //登录成功，生成Token
        Map<String,Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        claims.put(JwtClaimsConstant.USERNAME,user.getUsername());

        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims
        );

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .token(token)
                .build();

        return Result.success(userLoginVO);
    }

    /**
     * 用户注册接口
     * @param userRegisterDTO
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册接口")
    public Result register(@RequestBody UserRegisterDTO userRegisterDTO){

        User user = userService.findByUsername(userRegisterDTO.getUsername());

        if(user != null){
            return Result.error(MessageConstant.ACCOUNT_IS_EXIT);
        }

        userService.register(userRegisterDTO);

        return Result.success();
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PostMapping("/updateInfo")
    @ApiOperation("更新用户信息")
    public Result updateInfo(@RequestBody User user){

        userService.updateInfo(user);
        return Result.success();
    }
}
