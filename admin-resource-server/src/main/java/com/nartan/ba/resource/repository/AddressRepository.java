package com.nartan.ba.resource.repository;

import com.nartan.ba.resource.model.mappers.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author evahhl
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

  List<Address> findAll();

}
