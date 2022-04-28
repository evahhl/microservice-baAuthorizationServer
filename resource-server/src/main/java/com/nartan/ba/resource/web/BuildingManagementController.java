package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.BuildingManagement;
import com.nartan.ba.resource.service.BuildingManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author evahhl
 */
@RestController
@RequestMapping(value = "/buildingManagement")
public class BuildingManagementController {

  @Autowired
  private BuildingManagementService buildingManagementService;

  @GetMapping("/showBuildingsManagement")
  public List<BuildingManagement> findBuildings(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("buildingId"));

    List<BuildingManagement> buildings = buildingManagementService.findAll(paging);

    return buildings;
  }
}
