package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.mappers.Building;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 */
public interface BuildingService {

  List<Building> findAll(Pageable paging);

  Optional<Building> findByID(int id);

  void add(Building building);

  void delete(Building building);
}
