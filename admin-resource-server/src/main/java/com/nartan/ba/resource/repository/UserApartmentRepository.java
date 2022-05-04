package com.nartan.ba.resource.repository;

import com.nartan.ba.resource.model.mappers.UserApartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author evahhl
 */
@Repository
public interface UserApartmentRepository extends JpaRepository<UserApartment, Integer> {

  List<UserApartment> findAll();

}
