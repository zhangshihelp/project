package com.xuecheng.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 扫描实体类
@EntityScan("com.xuecheng.framework.domain.cms")
// 扫描接口
@ComponentScan(basePackages = {"com.xuecheng.api"})
// 扫描本项目下的所有类
@ComponentScan(basePackages = {"com.xuecheng.manage_cms"})
public class ManageCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageCmsApplication.class);
    }
}
