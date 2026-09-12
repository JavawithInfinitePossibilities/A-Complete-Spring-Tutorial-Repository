package com.tutorials.sid.spring.websecurityconfig;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Reads the logged-in user's username from SecurityContext and the
 * plain-text password from the HTTP session (saved there by LoginSuccessHandler
 * before Spring Security could erase it), then adds a Basic Auth header to
 * every outgoing RestTemplate request.
 */
@Component
public class LoggedInUserBasicAuthInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request,
                                        byte[] body,
                                        ClientHttpRequestExecution execution)
            throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            /** Read the plain password saved in session by LoginSuccessHandler.
             *  getCredentials() is null here because Spring Security erases it
             *  after login — the session is the only safe place to keep it.
             * */
            String password = getPasswordFromSession();
            System.out.println("Adding Basic Auth header for user: " + username + ", password: " + password);
            if (password != null && !password.isEmpty()) {
                String credentials = username + ":" + password;
                String encoded = Base64.getEncoder()
                        .encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
                request.getHeaders().set(HttpHeaders.AUTHORIZATION, "Basic " + encoded);
            }
        }

        return execution.execute(request, body);
    }

    /**
     * Retrieves the plain password stored in the current HTTP session.
     * Returns null if there is no active request context or no password stored.
     */
    private String getPasswordFromSession() {
        try {
            ServletRequestAttributes attrs =
                    (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpServletRequest httpRequest = attrs.getRequest();
            HttpSession session = httpRequest.getSession(false); // false = don't create new session
            if (session != null) {
                return (String) session.getAttribute(LoginSuccessHandler.SESSION_PASSWORD_KEY);
            }
        } catch (IllegalStateException e) {
            // No request context available (e.g. called from a background thread)
        }
        return null;
    }
}
