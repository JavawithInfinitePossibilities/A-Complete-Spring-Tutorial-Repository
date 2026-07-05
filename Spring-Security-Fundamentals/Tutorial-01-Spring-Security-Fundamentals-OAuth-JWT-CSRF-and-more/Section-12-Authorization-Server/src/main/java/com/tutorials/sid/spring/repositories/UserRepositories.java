/**
 * 
 */
package com.tutorials.sid.spring.repositories;

import com.tutorials.sid.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kunmu
 *
 */
public interface UserRepositories extends JpaRepository<User, Long> {
	public User findByEmail(String username);
}
