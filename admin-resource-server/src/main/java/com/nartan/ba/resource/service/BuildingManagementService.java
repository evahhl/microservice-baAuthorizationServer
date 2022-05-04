package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.mappers.BuildingManagement;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author evahhl
 */
public interface BuildingManagementService {

  List<BuildingManagement> findAll();

  void add(BuildingManagement buildingManagement);

  void delete(BuildingManagement buildingManagement);

  List<BuildingManagement> findAll(Pageable pageable);
}
