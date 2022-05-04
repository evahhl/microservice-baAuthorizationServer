package com.nartan.ba.resource.repository;

import com.nartan.ba.resource.model.mappers.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

  List<State> findAll();

  @Query("select s from #{#entityName} s where s.stateName = :stateName")
  State findbyStateName(@Param("stateName") String stateName);

  @Query("select s from #{#entityName} s where s.status = :status")
  List<State> findbyStatus(@Param("status") int status);
}
