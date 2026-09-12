package com.tutorials.sid.spring.config;

import com.tutorials.sid.spring.websecurityconfig.LoggedInUserBasicAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author kunmu On 28-12-2023
 */
@Configuration
public class DataSourceConfigDetails {

    @Autowired
    private LoggedInUserBasicAuthInterceptor loggedInUserBasicAuthInterceptor;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource springCoreRepository() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "transactionManager")
    public JdbcTransactionManager platformTransactionManager() {
        return new JdbcTransactionManager(springCoreRepository());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * RestTemplate that forwards the currently logged-in user's credentials
     * as a Basic Auth header on every outgoing request.
     * <p>
     * The interceptor reads from SecurityContextHolder at the time of the
     * actual HTTP call, so it always picks up the credentials of whichever
     * user is making the current request — not a fixed/hardcoded value.
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(List.of(loggedInUserBasicAuthInterceptor));
        return restTemplate;
    }
}
