/**
 * 
 */
package com.nartan.ba.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.nartan.ba.model.VUserInfo;

/**
 * @author evahhl
 *
 */
public interface VUserInfoService extends UserDetailsService {
	  VUserInfo findByEmail(String email);
	  UserDetails loadUserByUsername(final String username);
	}
