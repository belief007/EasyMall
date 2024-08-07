package com.EasyMall.ums;

import com.EasyMall.user.dto.UserLoginDTO;
import com.EasyMall.user.dto.UserRegisterDTO;
import com.EasyMall.user.entity.User;

public interface UserService {
    /**
     * 用户登录服务接口
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

    /**
     * 用户注册服务接口
     * @param userRegisterDTO
     */
    void register(UserRegisterDTO userRegisterDTO);

    /**
     * 查找用户接口
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 用户信息更新接口
     * @param user
     */
    void updateInfo(User user);
}
