package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.mappers.User;
import com.nartan.ba.resource.repository.UserRepository;
import com.nartan.ba.resource.service.UserService;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository repository;

  @Override
  public List<User> findAll(final Pageable pageable) {

    Page<User> pagedResult = repository.findAll(pageable);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return ImmutableList.of();
    }
  }

  @Override
  public Optional<User> findById(final int id) {
    return repository.findById(id);
  }

  @Override
  public void add(final User user) {
    repository.save(user);
  }

  @Override
  public void delete(final User user) {
    repository.save(user);
  }
}