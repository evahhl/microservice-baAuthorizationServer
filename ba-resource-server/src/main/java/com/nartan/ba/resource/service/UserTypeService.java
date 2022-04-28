package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.UserType;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 */
public interface UserTypeService {

  List<UserType> findAll(Pageable pageable);

  Optional<UserType> findById(int id);

  void add(UserType userType);

  void deleteById(int userTypeId);
}
