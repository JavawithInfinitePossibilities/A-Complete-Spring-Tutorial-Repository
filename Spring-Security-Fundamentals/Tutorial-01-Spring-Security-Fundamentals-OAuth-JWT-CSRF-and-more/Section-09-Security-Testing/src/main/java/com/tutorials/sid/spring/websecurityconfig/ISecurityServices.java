/**
 *
 */
package com.tutorials.sid.spring.websecurityconfig;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author kunmu
 *
 */
public interface ISecurityServices {

    boolean loginServices(String username, String password, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
}
