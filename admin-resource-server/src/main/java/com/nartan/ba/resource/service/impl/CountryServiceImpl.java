package com.nartan.ba.resource.service.impl;

import com.nartan.ba.resource.model.mappers.Country;
import com.nartan.ba.resource.repository.CountryRepository;
import com.nartan.ba.resource.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

  @Autowired
  private CountryRepository repository;

  @Override
  public List<Country> findAll() {

    List<Country> countries = (List<Country>) repository.findAll();

    return countries;
  }

  @Override
  public Optional<Country> findbyCountryId(String countryId) {

    return repository.findById(countryId);
  }

  @Override
  public Optional<Country> findbyCountryName(String countryName) {

    return repository.findById(countryName);
  }

  @Override
  public Optional<Country> findbyStatus(String status) {

    return repository.findById(status);
  }


  @Override
  public void addCountry(Country country) {
    repository.save(country);
  }

  @Override
  public void updateCountry(Country country) {
    repository.save(country);
  }
}