package com.EasyMall.mapper.ums;

import com.EasyMall.annotation.AutoFill;
import com.EasyMall.enumeration.OperationType;
import com.EasyMall.user.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
            "(username, password, update_time, create_time) " +
            "values (#{username}, #{password}, #{updateTime}, #{createTime})")
    @AutoFill(OperationType.USER_INSERT)
    void save(User user);

    /**
     * 用户信息更新
     * @param user
     */
    @AutoFill(OperationType.USER_UPDATE)
    void updateInfo(User user);
}
