package com.tutorials.sid.spring.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author kunmu On 02-07-2026
 */
@Data
@Component
@ConfigurationProperties(prefix = "currency-services")
public class CurrencyProfileDetails {
    private String url;
    private String user;
    private String password;
}
