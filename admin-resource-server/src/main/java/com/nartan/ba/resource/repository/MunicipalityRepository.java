package com.nartan.ba.resource.repository;

import com.nartan.ba.resource.model.mappers.Municipality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Integer> {

  Page<Municipality> findAll(@Param("pageable") Pageable pageable);

  @Query("select m from #{#entityName} m where m.municipalityName = :municipalityName")
  List<Municipality> findbyMunicipalityName(@Param("municipalityName") String municipalityName);

  @Query("select m from #{#entityName} m where m.status = :status")
  Page<Municipality> findbyStatus(@Param("status") int status,
      @Param("pageable") Pageable pageable);
}

