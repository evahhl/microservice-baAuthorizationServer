package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.mappers.Management;
import com.nartan.ba.resource.repository.ManagementRepository;
import com.nartan.ba.resource.service.ManagementService;
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
public class ManagementServiceImpl implements ManagementService {

  @Autowired
  private ManagementRepository repository;

  @Override
  public List<Management> findAll(final Pageable pageable) {

    Page<Management> pagedResult = repository.findAll(pageable);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return ImmutableList.of();
    }
  }

  @Override
  public Optional<Management> findById(final int id) {
    return repository.findById(id);
  }

  @Override
  public void add(final Management management) {
    repository.save(management);

  }

  @Override
  public void delete(final Management management) {
    repository.save(management);
  }
}
