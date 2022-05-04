package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.mappers.ZipCode;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZipCodeService {

  List<ZipCode> findAll();

  List<ZipCode> findAll(Pageable paging);

  List<ZipCode> findbyZipCode(String zipCode);

  List<ZipCode> findbyStatus(Pageable paging, int status);

  List<ZipCode> findbyNeighborhood(String neighborhood);

  List<ZipCode> findbyMunicipalityId(int municipalityId);

  List<ZipCode> findbyStateId(int stateId);

  List<ZipCode> findbyCountryId(int countryId);

  void addZipCode(ZipCode zipcode);

  void updateZipCode(ZipCode zipcode);
}
