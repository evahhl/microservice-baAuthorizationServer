package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.mappers.City;
import com.nartan.ba.resource.repository.CityRepository;
import com.nartan.ba.resource.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

  @Autowired
  private CityRepository repository;

  @Override
  public List<City> findAll(Pageable paging) {

    Page<City> pagedResult = repository.findAll(paging);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<City>();
    }
  }

  @Override
  public City findById(int id) {
    return repository.getById(id);
  }

  @Override
  public List<City> findByCityName(String cityName) {
    return repository.findByCityName(cityName);
  }

  @Override
  public List<City> findByMunicipalityName(String municipalityName) {

    return repository.findByMunicipalityName(municipalityName);
  }

  @Override
  public List<City> findByStatus(int status, Pageable paging) {

    Page<City> pagedResult = repository.findByStatus(status, paging);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<City>();
    }
  }


  @Override
  public void updateCity(City city) {
    repository.save(city);
  }

}