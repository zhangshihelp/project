package me.zs.mapper;

import me.zs.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void testQuery(){
        User user = userMapper.selectByPrimaryKey(8L);
        System.out.println(user);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("zhangsan");
        user.setPassword("123456");
        user.setName("张三");
        user.setAge(27);
        user.setSex(1);
        user.setBirthday(new Date(92,6,28,16,50,39));
        user.setCreated(new Date());
        user.setUpdated(new Date());
        userMapper.insert(user);
    }

    @Test
    public void testDate(){
        System.out.println(new Date(92,6,28,16,50,39));
    }
}