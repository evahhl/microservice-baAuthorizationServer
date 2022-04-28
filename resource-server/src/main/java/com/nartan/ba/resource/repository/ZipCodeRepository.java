package com.nartan.ba.resource.repository;

import com.nartan.ba.resource.model.ZipCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCode, String> {

  List<ZipCode> findAll();

  Page<ZipCode> findAll(@Param("pageable") Pageable pageable);

  @Query("select zc from #{#entityName} zc where zc.zipCode = :zipCode")
  List<ZipCode> findbyZipCode(@Param("zipCode") String zipCode);

  @Query("select zc from #{#entityName} zc where zc.neighborhood = :neighborhood")
  List<ZipCode> findbyNeighborhood(@Param("neighborhood") String neighborhood);

  @Query("select zc from #{#entityName} zc where zc.status = :status")
  Page<ZipCode> findbyStatus(@Param("pageable") Pageable pageable, @Param("status") int status);

  @Query("select zc from #{#entityName} zc, Municipality m where zc.municipality=m and m.municipalityId = :municipalityId")
  List<ZipCode> findbyMunicipalityId(@Param("municipalityId") int municipalityId);

  @Query("select zc from #{#entityName} zc, State s  where zc.state = s and s.stateId = :stateId")
  List<ZipCode> findbyStateId(@Param("stateId") int stateId);

  @Query("select zc from #{#entityName} zc, Country c  where zc.country = c and c.countryId = :countryId")
  List<ZipCode> findbyCountryId(@Param("countryId") int countryId);
}
