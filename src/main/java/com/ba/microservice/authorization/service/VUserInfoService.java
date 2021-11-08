/**
 * 
 */
package com.ba.microservice.authorization.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.ba.microservice.authorization.model.VUserInfo;

/**
 * @author evahhl
 *
 */
public interface VUserInfoService extends UserDetailsService {
	  VUserInfo findByEmail(String email);
	  UserDetails loadUserByUsername(final String username);
	}
