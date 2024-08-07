package com.EasyMall.admin.entity.ums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data//getter,setter,toString,hashCode,equals方法
@Builder
@NoArgsConstructor//无参构造器
@AllArgsConstructor//全参构造器
@Component// IOC
public class Admin implements Serializable {
    private Long id;
    private String username;
    private String password;
}
