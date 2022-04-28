package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.Parking;
import com.nartan.ba.resource.repository.ParkingRepository;
import com.nartan.ba.resource.service.ParkingService;
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
public class ParkingServiceImpl implements ParkingService {

  @Autowired
  private ParkingRepository repository;

  @Override
  public List<Parking> findAll(final Pageable pageable) {

    Page<Parking> pagedResult = repository.findAll(pageable);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return ImmutableList.of();
    }
  }

  @Override
  public Optional<Parking> findById(final int id) {
    return repository.findById(id);
  }

  @Override
  public void add(final Parking parking) {
    repository.save(parking);
  }

  @Override
  public void delete(final Parking parking) {
    repository.save(parking);
  }
}
