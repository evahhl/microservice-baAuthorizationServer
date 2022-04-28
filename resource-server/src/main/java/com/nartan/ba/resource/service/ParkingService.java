package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.Parking;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 */
public interface ParkingService {

  List<Parking> findAll(Pageable pageable);

  Optional<Parking> findById(int id);

  void add(Parking parking);

  void delete(Parking parking);
}
