package com.nartan.ba.service.impl;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nartan.ba.model.UserInfo;
import com.nartan.ba.model.VUserInfo;
import com.nartan.ba.repository.VUserInfoRepository;
import com.nartan.ba.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService {

  private final AuthenticationManager authenticationManager;
  private final VUserInfoRepository userLoginRepository;
  private final PasswordEncoder encoder;
  
  
  @Autowired
  public AuthenticationServiceImpl(
      final AuthenticationManager authenticationManager,
      final VUserInfoRepository userLoginRepository,
      final PasswordEncoder encoder
  ) {
    this.authenticationManager = authenticationManager;
    this.userLoginRepository = userLoginRepository;
    this.encoder = encoder;
  }

  public UserDetails login(
	      final String username,
	      final String password
	  ) throws Exception {
	    
	    UserInfo userLogin = null;
	    UserDetails userDetails;
		
		try {
			userLogin = authenticate(username, password);
			String user = Integer.toString(userLogin.getUserId());
			
			userDetails = new User(user, password, new ArrayList<>());
		} catch (Exception e) {			
			e.printStackTrace();		
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		return userDetails;
		
  }
  
  private UserInfo authenticate(String username, String password) throws Exception {
		
		try {
			VUserInfo vuserLogin = userLoginRepository.findByEmail(username);
			
			if(vuserLogin!=null ) {
				boolean isPasswordMatches = encoder.matches(password, vuserLogin.getPassword());  
							
				if(!isPasswordMatches) {
					throw new Exception("INVALID_CREDENTIALS");
				}
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			}else {
				throw new Exception("User not found with username: " + username);
		    }
			
			UserInfo userLogin = new UserInfo(vuserLogin);
			
			return userLogin;
			
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}		

}
