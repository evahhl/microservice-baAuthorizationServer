package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

  List<Country> findAll();

  Optional<Country> findbyCountryId(String countryId);

  Optional<Country> findbyCountryName(String countryName);

  Optional<Country> findbyStatus(String status);

  void addCountry(Country country);

  void updateCountry(Country country);
}
