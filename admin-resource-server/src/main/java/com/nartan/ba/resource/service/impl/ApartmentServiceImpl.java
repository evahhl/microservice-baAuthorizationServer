package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.mappers.Apartment;
import com.nartan.ba.resource.repository.ApartmentRepository;
import com.nartan.ba.resource.service.ApartmentService;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author evahhl
 */
@Service
public class ApartmentServiceImpl implements ApartmentService {

  @Autowired
  private ApartmentRepository repository;

  @Override
  public List<Apartment> findAll(final Pageable pageable) {

    Page<Apartment> pagedResult = repository.findAll(pageable);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return ImmutableList.of();
    }
  }

  @Override
  public void add(final Apartment apartment) {
    repository.save(apartment);

  }

  @Override
  public void deleteById(final int id) {
    repository.deleteById(id);
  }

  @Override
  public List<Apartment> findApartmentsByBuildingId(final int buildingId, final Pageable pageable) {

    Page<Apartment> pagedResult = repository.findApartmentsbyBuilding(buildingId, pageable);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return ImmutableList.of();
    }
  }
}
