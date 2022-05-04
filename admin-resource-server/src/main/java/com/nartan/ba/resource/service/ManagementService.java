package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.mappers.Management;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 */
public interface ManagementService {

  List<Management> findAll(Pageable pageable);

  Optional<Management> findById(int id);

  void add(Management management);

  void delete(Management management);
}
