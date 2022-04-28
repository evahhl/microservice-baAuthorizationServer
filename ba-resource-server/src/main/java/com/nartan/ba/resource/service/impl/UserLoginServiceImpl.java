package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.UserLogin;
import com.nartan.ba.resource.repository.UserLoginRepository;
import com.nartan.ba.resource.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author evahhl
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

  @Autowired
  private UserLoginRepository repository;

  @Override
  public List<UserLogin> findAll() {
    return repository.findAll();
  }

  @Override
  public void add(final UserLogin userLogin) {
    repository.save(userLogin);
  }

  @Override
  public void deleteById(final int id) {
    repository.deleteById(id);
  }

  @Override
  public UserLogin findByEmail(final String email) {
    return repository.findbyEmail(email);
  }

  @Override
  public UserLogin login(final String email, final String password) {
    return repository.login(email, password);
  }
}
