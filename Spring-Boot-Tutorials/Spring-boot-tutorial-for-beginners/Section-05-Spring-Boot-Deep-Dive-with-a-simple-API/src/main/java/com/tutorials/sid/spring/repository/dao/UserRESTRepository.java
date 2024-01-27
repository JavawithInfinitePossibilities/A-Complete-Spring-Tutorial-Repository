package com.tutorials.sid.spring.repository.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tutorials.sid.spring.model.entity.User;

/**
 * URL:http://localhost:8080/users
 * 
 * @author Lenovo
 *
 */

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRESTRepository extends PagingAndSortingRepository<User, Long> {

	public List<User> findByRole(@Param("role") String role);
}