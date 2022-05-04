package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.mappers.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 */
public interface UserService {

  List<User> findAll(Pageable pageable);

  Optional<User> findById(int id);

  void add(User user);

  void delete(User user);
}