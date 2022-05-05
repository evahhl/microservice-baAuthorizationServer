package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.mappers.ZipCode;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZipCodeService {

  List<ZipCode> findAll();

  List<ZipCode> findAll(Pageable paging);

  List<ZipCode> findByZipCode(String zipCode);

  List<ZipCode> findByStatus(Pageable paging, int status);

  List<ZipCode> findByNeighborhood(String neighborhood);

  List<ZipCode> findByCityId(int cityId);

  List<ZipCode> findByStateId(int stateId);

  List<ZipCode> findByCountryId(int countryId);

  void addZipCode(ZipCode zipcode);

  void updateZipCode(ZipCode zipcode);
}
