package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.mappers.Staff;
import com.nartan.ba.resource.repository.StaffRepository;
import com.nartan.ba.resource.service.StaffService;
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
public class StaffServiceImpl implements StaffService {

  @Autowired
  private StaffRepository repository;

  @Override
  public List<Staff> findAll(final Pageable pageable) {

    Page<Staff> pagedResult = repository.findAll(pageable);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return ImmutableList.of();
    }
  }

  @Override
  public Optional<Staff> findById(final int id) {
    return repository.findById(id);
  }

  @Override
  public void add(final Staff staff) {
    repository.save(staff);
  }

  @Override
  public void delete(final Staff staff) {
    repository.save(staff);
  }
}
