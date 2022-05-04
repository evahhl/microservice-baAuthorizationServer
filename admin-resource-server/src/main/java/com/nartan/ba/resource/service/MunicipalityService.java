package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.mappers.Municipality;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MunicipalityService {

  List<Municipality> findAll(Pageable pageable);

  Municipality findbyMunicipalityId(int municipalityId);

  List<Municipality> findbyMunicipalityName(String municipalityName);

  List<Municipality> findbyStatus(int status, Pageable pageable);

  void addUpdateMunicipality(Municipality municipality);
}
