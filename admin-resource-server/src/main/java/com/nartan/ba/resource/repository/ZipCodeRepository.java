package com.nartan.ba.resource.repository;

import com.nartan.ba.resource.model.mappers.ZipCode;
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
  List<ZipCode> findByZipCode(@Param("zipCode") String zipCode);

  @Query("select zc from #{#entityName} zc where zc.neighborhood = :neighborhood")
  List<ZipCode> findByNeighborhood(@Param("neighborhood") String neighborhood);

  @Query("select zc from #{#entityName} zc where zc.status = :status")
  Page<ZipCode> findByStatus(@Param("pageable") Pageable pageable, @Param("status") int status);

  @Query("select zc from #{#entityName} zc, City c where zc.city = c and c.id = :id")
  List<ZipCode> findByCityId(@Param("id") int id);

  @Query("select zc from #{#entityName} zc, State s  where zc.state = s and s.id = :id")
  List<ZipCode> findByStateId(@Param("id") int id);

  @Query("select zc from #{#entityName} zc, Country c  where zc.country = c and c.id = :id")
  List<ZipCode> findByCountryId(@Param("id") int id);
}
