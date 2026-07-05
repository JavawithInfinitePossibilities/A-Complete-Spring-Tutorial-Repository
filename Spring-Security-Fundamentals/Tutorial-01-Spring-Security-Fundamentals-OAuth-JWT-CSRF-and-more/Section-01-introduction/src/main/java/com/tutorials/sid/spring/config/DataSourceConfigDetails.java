package com.tutorials.sid.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.support.JdbcTransactionManager;

import javax.sql.DataSource;

/**
 * @author kunmu On 28-12-2023
 */
@Configuration
public class DataSourceConfigDetails {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource springCoreRepository() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTransactionManager platformTransactionManager() {
        return new JdbcTransactionManager(springCoreRepository());
    }
}
