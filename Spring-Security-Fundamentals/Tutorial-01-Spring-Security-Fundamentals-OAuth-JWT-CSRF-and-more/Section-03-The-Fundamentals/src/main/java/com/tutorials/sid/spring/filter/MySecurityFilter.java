/**
 *
 */
package com.tutorials.sid.spring.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author Lenovo
 *
 */
@Component
public class MySecurityFilter implements Filter {

    /*
     * To make sure the filter class get called once use OncePerRequestFilter.
     * This class implements the Filter interface and provides a custom filter.
     * The doFilter method is overridden to intercept the requests and responses before and after they are processed by the FilterChain.
     * In this example, it logs messages before and after each request is processed.
     * We can use GenericFilterBean instead of filter interface too.
     * @author Lenovo
     *
     */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Before request!!!");
        chain.doFilter(request, response);
        System.out.println("After Request!!!");
    }
}
