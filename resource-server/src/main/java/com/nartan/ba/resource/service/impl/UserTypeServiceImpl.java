/**
 *
 */
package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.UserType;
import com.nartan.ba.resource.repository.UserTypeRepository;
import com.nartan.ba.resource.service.UserTypeService;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 *
 */
@Service
public class UserTypeServiceImpl implements UserTypeService {

  @Autowired
  private UserTypeRepository repository;

  @Override
  public List<UserType> findAll(final Pageable pageable) {

    Page<UserType> pagedResult = repository.findAll(pageable);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return ImmutableList.of();
    }
  }

  @Override
  public Optional<UserType> findById(final int id) {

    return repository.findById(id);
  }

  @Override
  public void add(final UserType userType) {
    repository.save(userType);
  }

  @Override
  public void deleteById(final int userTypeId) {
    repository.deleteById(userTypeId);
  }
}
