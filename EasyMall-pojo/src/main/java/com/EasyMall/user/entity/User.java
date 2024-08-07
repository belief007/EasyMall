package com.EasyMall.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data//getter,setter,toString,hashCode,equals方法
@Builder
@NoArgsConstructor//无参构造器
@AllArgsConstructor//全参构造器
@Component// IOC
public class User {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
