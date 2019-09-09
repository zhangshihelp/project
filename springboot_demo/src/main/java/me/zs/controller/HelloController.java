package me.zs.controller;

import lombok.extern.slf4j.Slf4j;
import me.zs.pojo.User;
import me.zs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
//使用该注解相当于@Controller和@ResponseBody的结合，此时的Controller无法返回jsp或者html页面
//@RestController
@Slf4j
@RequestMapping("/user")
public class HelloController {

    /*@Autowired
    private DataSource dataSource;*/

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User hello(@PathVariable("id") Long id){
        log.debug("hello method is running");
        return userService.queryById(id);
    }
}
