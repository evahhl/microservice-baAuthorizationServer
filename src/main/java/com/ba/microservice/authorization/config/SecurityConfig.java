/**
 * 
 */
package com.ba.microservice.authorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.ba.microservice.authorization.repository.VUserInfoRepository;
import com.ba.microservice.authorization.service.AuthenticationService;
import com.ba.microservice.authorization.service.VUserInfoService;
import com.ba.microservice.authorization.service.impl.AuthenticationServiceImpl;
import com.ba.microservice.authorization.service.impl.VUserInfoServiceImpl;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class SecurityConfig {
	

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
          authorizeRequests.anyRequest().authenticated()
        )
          .formLogin(withDefaults());
        return http.build();
    }

   /* @Bean
    UserDetailsService users() {
        UserDetails user = User.withDefaultPasswordEncoder()
          .username("admin")
          .password("password")
          .roles("USER")
          .build();
        return new InMemoryUserDetailsManager(user);
    }*/
    
    @Bean
    UserDetailsService users(String username, String password) {
        UserDetails user = User.withDefaultPasswordEncoder()
          .username("admin")
          .password("password")
          .roles("USER")
          .build();
        
        AuthenticationService.login(username, password));
        
        return new InMemoryUserDetailsManager(user);
    } 
    
    @Bean
    public AuthenticationService authenticationService(
        AuthenticationManager authenticationManager,
        VUserInfoRepository userLoginRepository,
        PasswordEncoder passwordEncoder,
        JwtProvider jwtProvider
    ) {
      return new AuthenticationServiceImpl(authenticationManager, userLoginRepository,
          passwordEncoder, jwtProvider);
    }

    @Bean
    public VUserInfoService userLoginService(VUserInfoRepository userLoginRepository) {
      return new VUserInfoServiceImpl(userLoginRepository);
    }


}