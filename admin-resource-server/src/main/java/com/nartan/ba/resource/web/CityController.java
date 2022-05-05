package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.mappers.City;
import com.nartan.ba.resource.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/city")
public class CityController {

  @Autowired
  private CityService cityService;


  @GetMapping("/showAll")
  public List<City> findCities(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("id"));

    return cityService.findAll(paging);
  }

  @GetMapping("/findById/{id}")
  public City findById(@PathVariable("id") int id) {
    return cityService.findById(id);
  }

  @PostMapping("/findbyMunicipalityName")
  public List<City> findbyMunicipalityName(@RequestBody City municipality) {

    return cityService.findByMunicipalityName(municipality.getMunicipalityName());
  }

  @GetMapping("/findbyStatus/{status}")
  public List<City> findbyStatus(@PathVariable("status") int status,
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("municipalityId"));

    return cityService.findByStatus(status, paging);
  }


  @PostMapping(path = "/add")
  public void addMunicipality(@RequestBody City municipality) {

    cityService.updateCity(municipality);
  }

  @GetMapping(path = "/delete/{id}")
  public void deleteMunicipality(@PathVariable("id") int id) {
    City city = cityService.findById(id);
    city.setStatus(0);
    cityService.updateCity(city);
  }
}
