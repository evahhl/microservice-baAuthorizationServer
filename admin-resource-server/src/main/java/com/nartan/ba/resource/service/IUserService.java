/**
 * 
 */
package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.mappers.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 *
 */
public interface IUserService {
	
	List<User> findAll(Pageable pageable);
	
	Optional<User> findUserId(int userId);
	
	User findbyEmail(String email);
	 
	void addUser(User user);
	 
	void deleteUser(User user);


}
