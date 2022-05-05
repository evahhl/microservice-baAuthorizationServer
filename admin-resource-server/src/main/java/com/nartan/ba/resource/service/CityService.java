package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.mappers.City;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {

  List<City> findAll(Pageable pageable);

  City findById(int id);

  List<City> findByCityName(String cityName);

  List<City> findByMunicipalityName(String municipalityName);

  List<City> findByStatus(int status, Pageable pageable);

  void updateCity(City city);
}
