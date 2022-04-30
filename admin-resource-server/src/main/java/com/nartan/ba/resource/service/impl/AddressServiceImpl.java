package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.Address;
import com.nartan.ba.resource.repository.AddressRepository;
import com.nartan.ba.resource.service.AddressService;
import com.google.common.collect.ImmutableList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

  private final AddressRepository repository;

  public AddressServiceImpl(AddressRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Address> findAll(final Pageable pageable) {

    Page<Address> pagedResult = repository.findAll(pageable);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return ImmutableList.of();
    }
  }

  @Override
  public void add(Address address) {
    repository.save(address);
  }

  @Override
  public void deleteById(final int id) {
    repository.deleteById(id);
  }

  @Override
  public Optional<Address> findById(final int id) {
    return repository.findById(id);
  }
}
