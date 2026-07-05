package com.tutorials.sid.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

/**
 * @author kunmu On 28-12-2023
 */
@Configuration
public class DataSourceConfigDetails {
    /*
     * The below configuration is needed if you are using multiple datasource.
     * If you are using a single datasource, then, you can remove the below configuration.
     * Application will use the default datasource and create a transaction manager for it.
     * */
    /*@Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource springCoreRepository() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "transactionManager")
    public JdbcTransactionManager platformTransactionManager() {
        return new JdbcTransactionManager(springCoreRepository());
    }*/

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
