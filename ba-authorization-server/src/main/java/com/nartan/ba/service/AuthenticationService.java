package com.nartan.ba.service;

import org.springframework.security.core.userdetails.UserDetails;


public interface AuthenticationService {

	UserDetails login(String username, String password) throws Exception;
}
