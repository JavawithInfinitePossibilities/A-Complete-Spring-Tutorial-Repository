/**
 *
 */
package com.tutorials.sid.spring.config;

import com.tutorials.sid.spring.filter.MySecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author Lenovo
 */
@Configuration
public class MySecurityConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /* For lesson 18 and 19 disable the MyAuthenticationProvider class by commenting the @Component annotation.
     * And commenting the below autowire.
     * For Lesson 21 uncomment the below autowire.
     * */
    @Autowired
    private MyAuthenticationProvider authenticationProvider;

    @Autowired
    private MySecurityFilter filter;

    /*  This is for lesson 18 19.
     *  This is the basic authentication mechanism using username and password using
     *  In-Memory User Details Manager.
     *  comment the below method when using the MyAuthenticationProvider.
     * */
    /*@Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager userDetailsInmemory = new InMemoryUserDetailsManager();
        UserDetails userDetails = User.withUsername("sid")
                .password(passwordEncoder.encode("sahu"))
                .authorities("read")
                .build();
        userDetailsInmemory.createUser(userDetails);
        return userDetailsInmemory;
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*This is used in the lesson-18*/
        http.httpBasic(Customizer.withDefaults());
        /*
         * This will give a nice UI for the login page which will be used to login.
         * */
        /*http.formLogin(Customizer.withDefaults());*/

        /* This is lesson 19
        This is for any request authenticated by using username and password.*/
        /*http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                authorizationManagerRequestMatcherRegistry.anyRequest().authenticated());*/

        /*  This is for the lesson 21.
         *  This mechanism is for any request that is authenticated by using username and password
         *  have the access to /hello but rest of the URL are not permitted to access.
         * */
        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                authorizationManagerRequestMatcherRegistry.requestMatchers("/hello").authenticated()
                        .anyRequest().denyAll());
        /*
         * By just declaring the filter, it will be added to the filter chain.
         * No need to add it to the filter chain manually.
         * The old way of adding the filter to the filter chain is commented below.
         *  @Autowired
         *  private MySecurityFilter filter;
         */
         http.addFilterBefore(filter, BasicAuthenticationFilter.class);
        return http.build();
    }
}
