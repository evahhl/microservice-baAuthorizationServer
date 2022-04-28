package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.Apartment;
import com.nartan.ba.resource.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author evahhl
 */
@RestController
@RequestMapping(value = "/apartment")
public class ApartmentController {

  @Autowired
  private ApartmentService apartmentService;

  @GetMapping("/show/all")
  public List<Apartment> findAll(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("apartmentId"));

    List<Apartment> apartments = apartmentService.findAll(paging);

    return apartments;
  }

  @GetMapping("/findApartmentsbyBuilding/{buildingId}")
  public List<Apartment> findApartmentsbyBuilding(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @PathVariable("buildingId") int buildingId) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("apartmentId"));

    List<Apartment> apartments = apartmentService.findApartmentsByBuildingId(buildingId, paging);

    return apartments;
  }

  @PostMapping(path = "/add")
  public void addApartment(@RequestBody Apartment apartment) {

    apartmentService.add(apartment);
  }

  @PostMapping(path = "/delete/{apartmentId}")
  public void deleteApartment(@PathVariable("apartmentId") int apartmentId) {
    apartmentService.deleteById(apartmentId);
  }
}
