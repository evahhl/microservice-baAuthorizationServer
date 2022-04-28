package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.Address;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 */
public interface AddressService {

  List<Address> findAll(Pageable pageable);

  Optional<Address> findById(int id);

  void add(Address address);

  void deleteById(int id);
}
