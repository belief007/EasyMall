package com.EasyMall.ums.impl;

import com.EasyMall.constant.MessageConstant;
import com.EasyMall.exception.AccountNotFoundException;
import com.EasyMall.exception.PasswordErrorException;
import com.EasyMall.mapper.ums.UserMapper;
import com.EasyMall.ums.UserService;
import com.EasyMall.user.dto.UserLoginDTO;
import com.EasyMall.user.dto.UserRegisterDTO;
import com.EasyMall.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录服务接口实现
     * @param userLoginDTO
     * @return
     */
    @Override
    public User login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        //根据用户名查询数据库中的数据
        User user = userMapper.findByUsername(username);
        //TODO 完善用户登录校验逻辑

        //处理各种异常，用户名不存在，密码不对，账号被锁定
        if(user == null){
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NO_FOUND);
        }

        //密码对比
        //对前端传过来的明文密码进行md5加密
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if(!password.equals(user.getPassword())){
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        //TODO 账号被锁定时抛出的异常

        return user;
    }

    /**
     * 用户注册服务
     * @param userRegisterDTO
     */
    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        User user = new User();

        BeanUtils.copyProperties(userRegisterDTO,user);

        //设置密码加密方式
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

        userMapper.save(user);
    }

    /**
     * 查找用户
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * 更新用户信息接口
     * @param user
     */
    @Override
    public void updateInfo(User user) {
        userMapper.updateInfo(user);
    }


}
