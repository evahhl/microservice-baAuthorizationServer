package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.mappers.Apartment;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author evahhl
 */
public interface ApartmentService {

  List<Apartment> findAll(Pageable pageable);

  List<Apartment> findApartmentsByBuildingId(int buildingId, Pageable pageable);

  void add(Apartment apartment);

  void deleteById(int id);
}
