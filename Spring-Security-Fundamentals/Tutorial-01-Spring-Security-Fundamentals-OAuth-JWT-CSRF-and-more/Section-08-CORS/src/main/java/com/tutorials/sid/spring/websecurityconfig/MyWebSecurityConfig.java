/**
 *
 */
package com.tutorials.sid.spring.websecurityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

/**
 * @author Lenovo
 */
@Configuration
public class MyWebSecurityConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServicesImpl userDetailsServicesImpl;


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServicesImpl);
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsServicesImpl);
        provider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(provider);
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        DelegatingSecurityContextRepository repository = new DelegatingSecurityContextRepository
                (new RequestAttributeSecurityContextRepository(), new HttpSessionSecurityContextRepository());
        return repository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                authorizationManagerRequestMatcherRegistry
                        /*The below requestMatchers will allow all kinds of request with value to send it.*/
                        /*.requestMatchers(HttpMethod.GET, "/couponapi/getcoupon/**")*/
                        /*The below requestMatchers will allow all kinds of requests with value loke SUPERSEAL202609 to send it.*/
                        .requestMatchers(HttpMethod.GET, "/couponapi/getcoupon/{couponCode:^[A-Z0-9]*$}", "/index", "/showGetCoupon", "/getCoupon", "/couponDetails")
                        .hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/showCreateCoupon", "/createCoupon", "/createResponse").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/couponapi/couponsave", "/saveCoupon").hasRole("ADMIN")
                        .requestMatchers("/", "/login", "/logout", "/showReg", "/registerUser").permitAll()
                        .anyRequest().denyAll());
        /*http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());*/
        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.ignoringRequestMatchers("/couponapi/getcoupon/**"));
        http.securityContext(securityContextConfigurer -> securityContextConfigurer.requireExplicitSave(true));
        return http.build();
    }
}
