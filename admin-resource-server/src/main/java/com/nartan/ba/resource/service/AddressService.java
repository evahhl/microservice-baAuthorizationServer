package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.mappers.Address;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 */
public interface AddressService {

  List<Address> findAll(Pageable pageable);

  Optional<Address> findById(int id);

  Address add(Address address);

  void deleteById(int id);
}
