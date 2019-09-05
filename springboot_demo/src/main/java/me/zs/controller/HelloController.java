package me.zs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@Controller
//使用该注解相当于@Controller和@ResponseBody的结合，此时的Controller无法返回jsp或者html页面
//@RestController
@Slf4j
public class HelloController {

    /*@Autowired
    private DataSource dataSource;*/

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        log.debug("hello method is running");
        return "hello springboot!!!";
    }
}
