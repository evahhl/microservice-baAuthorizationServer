package com.nartan.ba.resource.repository;

import com.nartan.ba.resource.model.BuildingManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author evahhl
 */
@Repository
public interface BuildingManagementRepository extends JpaRepository<BuildingManagement, Integer> {

  List<BuildingManagement> findAll();
}
