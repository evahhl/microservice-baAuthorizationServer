package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.mappers.UserApartment;
import com.nartan.ba.resource.repository.UserApartmentRepository;
import com.nartan.ba.resource.service.UserApartmentService;
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
public class UserApartmentServiceImpl implements UserApartmentService {

  @Autowired
  private UserApartmentRepository repository;

  @Override
  public List<UserApartment> findAll(final Pageable pageable) {

    Page<UserApartment> pagedResult = repository.findAll(pageable);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return ImmutableList.of();
    }
  }

  @Override
  public Optional<UserApartment> findUserApartmentId(final int userApartmentId) {

    return repository.findById(userApartmentId);
  }

  @Override
  public void addUserApartment(UserApartment userApartment) {
    repository.save(userApartment);
  }

  @Override
  public void deleteUserApartment(int userApartmentId) {
    repository.deleteById(userApartmentId);
  }
}
