/**
 * 
 */
package com.tutorials.sid.spring.repositories;

import com.tutorials.sid.spring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kunmu
 *
 */
public interface RoleRepositories extends JpaRepository<Role, Long> {

}
