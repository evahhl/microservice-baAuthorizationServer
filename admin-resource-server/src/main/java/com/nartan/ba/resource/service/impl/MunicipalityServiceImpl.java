package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.mappers.Municipality;
import com.nartan.ba.resource.repository.MunicipalityRepository;
import com.nartan.ba.resource.service.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MunicipalityServiceImpl implements MunicipalityService {

  @Autowired
  private MunicipalityRepository repository;

  @Override
  public List<Municipality> findAll(Pageable paging) {

    Page<Municipality> pagedResult = repository.findAll(paging);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<Municipality>();
    }
  }

  @Override
  public Municipality findbyMunicipalityId(int municipalityId) {

    Municipality municipalities = repository.getById(municipalityId);

    return municipalities;
  }

  @Override
  public List<Municipality> findbyMunicipalityName(String municipalityName) {

    return repository.findbyMunicipalityName(municipalityName);
  }

  @Override
  public List<Municipality> findbyStatus(int status, Pageable paging) {

    Page<Municipality> pagedResult = repository.findbyStatus(status, paging);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<Municipality>();
    }
  }


  @Override
  public void addUpdateMunicipality(Municipality municipality) {
    repository.save(municipality);
  }

}