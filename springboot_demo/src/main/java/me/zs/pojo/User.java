package me.zs.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

//自动生成getter和setter
@Data
@Table(name = "tb_user")
public class User {

    //id
    //主键注解
    @Id
    //如果插入的表id以自增列为主键，则允许JDBC支持自动生成主键，并可将自动生成的主键id返回
    @KeySql(useGeneratedKeys = true)
    private Long id;

    //用户名
    private String userName;

    //密码
    private String password;

    //姓名
    private String name;

    //年龄
    private Integer age;

    //性别：1男性，2女性
    private Integer sex;

    //出生日期
    private Date birthday;

    //创建时间
    private Date created;

    //更新时间
    private Date updated;

    //备注
    //非数据库字段配置该注解
    @Transient
    private String note;
}
