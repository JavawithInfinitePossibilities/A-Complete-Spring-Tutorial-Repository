/**
 *
 */
package com.tutorials.sid.spring.websecurityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(auth -> auth
                // GET /couponapi/getcoupon/** — any authenticated user with USER or ADMIN role
                // Using hasAnyAuthority with the full "ROLE_" prefix because
                // Role.getAuthority() returns the name as-is from DB (e.g. "ROLE_USER")
                // hasAnyAuthority does NOT add the ROLE_ prefix — it matches exactly
                .requestMatchers(HttpMethod.GET, "/couponapi/getcoupon/**")
                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                // POST /couponapi/couponsave — only ADMIN
                .requestMatchers(HttpMethod.POST, "/couponapi/couponsave")
                .hasAuthority("ROLE_ADMIN")
                // All other requests must be authenticated
                .anyRequest().authenticated()
        );
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
