/**
 *
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Lenovo
 *import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
 *@EnableEurekaClient: This has been removed from the Spring cloud discovery services.
 * the version from which it is disabled from 2022.0.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Section02SpringCloudProductServices {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Section02SpringCloudProductServices.class, args);
    }

}
