package com.EasyMall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.EasyMall.*")
@EnableTransactionManagement //开启注解方式的事务管理
@Slf4j
@EnableCaching    //开启缓存注解功能
@EnableScheduling
public class EasyMallManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyMallManagementApplication.class, args);
    }

}
