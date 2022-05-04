package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.mappers.ZipCode;
import com.nartan.ba.resource.repository.ZipCodeRepository;
import com.nartan.ba.resource.service.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {

  @Autowired
  private ZipCodeRepository repository;


  @Override
  public List<ZipCode> findAll() {

    List<ZipCode> zipCodes = repository.findAll();

    return zipCodes;
  }

  @Override
  public List<ZipCode> findAll(Pageable pageable) {

    Page<ZipCode> pagedResult = repository.findAll(pageable);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<ZipCode>();
    }
  }

  @Override
  public List<ZipCode> findbyZipCode(String zipCode) {

    List<ZipCode> zipCodes = (List<ZipCode>) repository.findbyZipCode(zipCode);

    return zipCodes;
  }

  @Override
  public List<ZipCode> findbyNeighborhood(String neighborhood) {

    List<ZipCode> zipCodes = (List<ZipCode>) repository.findAll();

    return zipCodes;
  }

  @Override
  public List<ZipCode> findbyMunicipalityId(int id) {
    List<ZipCode> zipCodes = (List<ZipCode>) repository.findbyMunicipalityId(id);

    return zipCodes;
  }

  @Override
  public List<ZipCode> findbyStateId(int id) {

    List<ZipCode> zipCodes = (List<ZipCode>) repository.findbyStateId(id);

    return zipCodes;
  }

  @Override
  public List<ZipCode> findbyCountryId(int id) {

    List<ZipCode> zipCodes = (List<ZipCode>) repository.findbyCountryId(id);

    return zipCodes;
  }

  @Override
  public void addZipCode(ZipCode zipcode) {
    repository.save(zipcode);
  }

  @Override
  public void updateZipCode(ZipCode zipcode) {
    repository.save(zipcode);
  }

  @Override
  public List<ZipCode> findbyStatus(Pageable paging, int status) {

    Page<ZipCode> pagedResult = repository.findbyStatus(paging, status);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<ZipCode>();
    }
  }


}
