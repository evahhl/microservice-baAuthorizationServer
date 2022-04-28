package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.UserLogin;

import java.util.List;

/**
 * @author evahhl
 */
public interface UserLoginService {

//  List<UserLogin> findAll();

  UserLogin findByEmail(String email);

  UserLogin login(String email, String password);

  void add(UserLogin userLogin);

  void deleteById(int id);
}
