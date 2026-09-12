/**
 *
 */
package com.tutorials.sid.spring.websecurityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    /**
     * Builds an explicit AuthenticationManager so we control:
     *  1. Which UserDetailsService and PasswordEncoder are used
     *  2. eraseCredentialsAfterAuthentication = false — keeps the plain-text
     *     password in Authentication.getCredentials() long enough for
     *     LoginSuccessHandler to read and store it in the HTTP session.
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        // DaoAuthenticationProvider(UserDetailsService) — sets UserDetailsService via constructor
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(userDetailsServicesImpl);
        // Must also set PasswordEncoder so BCrypt hashes are validated correctly
        provider.setPasswordEncoder(passwordEncoder);
        ProviderManager providerManager = new ProviderManager(provider);
        // Keep the plain password in the Authentication object so
        // LoginSuccessHandler.onAuthenticationSuccess() can still read it
        providerManager.setEraseCredentialsAfterAuthentication(false);
        return providerManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Wire our explicit AuthenticationManager into the filter chain
        // so form login uses it instead of Spring Boot's auto-configured one
        http.authenticationManager(authenticationManager());
        http.formLogin(form -> form
                .loginPage("/productapi/login")
                .loginProcessingUrl("/productapi/login")
                // Saves plain password to session BEFORE Spring erases it
                .successHandler(loginSuccessHandler)
                .failureUrl("/productapi/login?error")
                .permitAll()
        );
        http.logout(logout -> logout
                .logoutUrl("/productapi/logout")
                .logoutSuccessUrl("/productapi/login?logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll()
        );
        http.authorizeHttpRequests(auth ->
                auth
                    .requestMatchers("/css/**", "/js/**", "/productapi/login").permitAll()
                    .anyRequest().authenticated()
        );
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
