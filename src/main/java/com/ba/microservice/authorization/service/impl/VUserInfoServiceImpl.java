/**
 * 
 */
package com.ba.microservice.authorization.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ba.microservice.authorization.model.VUserInfo;
import com.ba.microservice.authorization.repository.VUserInfoRepository;
import com.ba.microservice.authorization.service.VUserInfoService;

/**
 * @author evahhl
 *
 */
public class VUserInfoServiceImpl implements VUserInfoService {

	  private final VUserInfoRepository repository;

	  @Autowired
	  public VUserInfoServiceImpl(VUserInfoRepository repository) {
	    this.repository = repository;
	  }

	  @Override
	  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		  VUserInfo userLogin = repository.findByEmail(username);

	    if (userLogin != null) {
	      return new User(username, userLogin.getPassword(), new ArrayList<>());
	    } else {
	      throw new UsernameNotFoundException("User not found with username: " + username);
	    }
	  }

	  public VUserInfo findByEmail(final String email) {
	    return repository.findByEmail(email);
	  }
	}
