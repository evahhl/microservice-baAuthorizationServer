package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.mappers.Building;
import com.nartan.ba.resource.repository.BuildingRepository;
import com.nartan.ba.resource.service.BuildingService;
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
public class BuildingServiceImpl implements BuildingService {

  @Autowired
  private BuildingRepository repository;

  @Override
  public List<Building> findAll(final Pageable paging) {

    Page<Building> pagedResult = repository.findAll(paging);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return ImmutableList.of();
    }
  }

  @Override
  public Optional<Building> findByID(final int id) {
    return repository.findById(id);
  }

  @Override
  public void add(final Building building) {
    repository.save(building);
  }

  @Override
  public void delete(final Building building) {
    repository.save(building);
  }
}
