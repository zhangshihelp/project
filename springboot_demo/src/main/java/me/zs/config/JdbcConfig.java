package me.zs.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    /*@Bean
    public DataSource dataSource(JdbcProperties jdbcProperties) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(jdbcProperties.getDriverClassName());
        druidDataSource.setUrl(jdbcProperties.getUrl());
        druidDataSource.setUsername(jdbcProperties.getUsername());
        druidDataSource.setPassword(jdbcProperties.getPassword());
        return druidDataSource;
    }*/

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
