package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.BuildingManagement;
import com.nartan.ba.resource.repository.BuildingManagementRepository;
import com.nartan.ba.resource.service.BuildingManagementService;
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
public class BuildingManagementServiceImpl implements BuildingManagementService {

  @Autowired
  private BuildingManagementRepository repository;

  @Override
  public List<BuildingManagement> findAll() {

    return repository.findAll();
  }

  @Override
  public void add(final BuildingManagement buildingManagement) {
    repository.save(buildingManagement);
  }

  @Override
  public void delete(final BuildingManagement buildingManagement) {
    repository.save(buildingManagement);

  }

  @Override
  public List<BuildingManagement> findAll(final Pageable pageable) {

    Page<BuildingManagement> pagedResult = repository.findAll(pageable);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return ImmutableList.of();
    }
  }
}
