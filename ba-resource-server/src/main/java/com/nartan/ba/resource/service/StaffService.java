package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.Staff;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 */
public interface StaffService {

  List<Staff> findAll(Pageable pageable);

  Optional<Staff> findById(int id);

  void add(Staff staff);

  void delete(Staff staff);
}
