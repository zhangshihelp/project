package me.zs.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "jdbc")
@Data
public class JdbcProperties {
    private String url;
    private String driverClassName;
    private String username;
    private String password;
}
