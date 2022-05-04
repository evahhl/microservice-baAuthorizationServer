package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.mappers.Building;
import com.nartan.ba.resource.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 */
@RestController
@RequestMapping(value = "/building")
public class BuildingController {

  @Autowired
  private BuildingService buildingService;

  @GetMapping("/showBuildings")
  public List<Building> findBuildings(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("buildingId"));

    List<Building> buildings = buildingService.findAll(paging);

    return buildings;
  }

  @GetMapping("/findBuildingbyId/{buildingId}")
  public Optional<Building> findBuildingbyId(@PathVariable("buildingId") int buildingId) {

    Optional<Building> building = buildingService.findByID(buildingId);

    return building;
  }

  @PostMapping(path = "/add")
  public void addBuilding(@RequestBody Building building) {

    buildingService.add(building);
  }

  @GetMapping(path = "/delete/{buildingId}")
  public void deleteBuilding(@PathVariable("buildingId") int buildingId) {
    Optional<Building> building = buildingService.findByID(buildingId);
    if (building.isEmpty()) {
      System.out.println("deleteBuilding vacio, no hay nada que borrar");
    } else {
      building.get().setStatus(0);
      buildingService.delete(building.get());
      System.out.println("deleteBuilding registro borrado " + building.get().getBuildingId());
    }
  }
}
