package com.tutorials.sid.spring.websecurityconfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Runs immediately after a successful login, BEFORE Spring Security
 * calls eraseCredentials() on the Authentication object.
 * <p>
 * At this point authentication.getCredentials() still holds the
 * plain-text password the user just typed. We save it into the
 * HTTP session so the RestTemplate interceptor can read it later
 * when forwarding calls to the coupon service.
 * <p>
 * We extend SavedRequestAwareAuthenticationSuccessHandler so that
 * Spring's "redirect to the page you were trying to reach" behaviour
 * is preserved (same as the default success handler).
 */
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    // Key used to store/retrieve the plain password in the HTTP session
    public static final String SESSION_PASSWORD_KEY = "LOGGED_IN_USER_PASSWORD";

    public LoginSuccessHandler() {
        // After login always go to the home page
        setDefaultTargetUrl("/productapi/");
        setAlwaysUseDefaultTargetUrl(true);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws ServletException, IOException {
        // getCredentials() is the plain password at this exact moment —
        // Spring erases it AFTER this handler returns, not before
        if (authentication.getCredentials() != null) {
            String plainPassword = authentication.getCredentials().toString();
            System.out.println("plainPassword :" + plainPassword);
            request.getSession().setAttribute(SESSION_PASSWORD_KEY, plainPassword);
        }
        // Continue with the normal redirect behaviour
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
