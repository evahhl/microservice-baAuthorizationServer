package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.UserApartment;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 */
public interface UserApartmentService {

  List<UserApartment> findAll(Pageable pageable);

  Optional<UserApartment> findUserApartmentId(int userApartmentId);

  void addUserApartment(UserApartment userApartment);

  void deleteUserApartment(int userApartmentId);
}
