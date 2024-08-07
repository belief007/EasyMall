package com.EasyMall.ums;

import com.EasyMall.user.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户端用户mapper层
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
    @Select("select * from ums_user where username = #{username}")
    User findByUsername(String username);


    /**
     * 注册新用户
     * @param user
     */
    @Insert("insert into ums_user" +
            "(username, password) values (#{username}, #{password})")
    void save(User user);
}
