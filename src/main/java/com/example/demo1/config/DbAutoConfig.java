package com.example.demo1.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DbProperties.class)
@ConditionalOnClass(DBClinet.class)
public class DbAutoConfig {


    @Autowired
    private DbProperties dbProperties;

    @Bean
    public DBClinet getDbClient() {
        return new DBClinet(dbProperties);
    }

}
