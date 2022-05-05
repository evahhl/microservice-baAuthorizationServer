package com.nartan.ba.resource.repository;

import com.nartan.ba.resource.model.mappers.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

  Page<City> findAll(@Param("pageable") Pageable pageable);

  @Query("select c from #{#entityName} c where c.cityName = :cityName")
  List<City> findByCityName(@Param("cityName") String cityName);

  @Query("select c from #{#entityName} c where c.municipalityName = :municipalityName")
  List<City> findByMunicipalityName(@Param("municipalityName") String municipalityName);

  @Query("select c from #{#entityName} c where c.status = :status")
  Page<City> findByStatus(@Param("status") int status,
      @Param("pageable") Pageable pageable);
}

