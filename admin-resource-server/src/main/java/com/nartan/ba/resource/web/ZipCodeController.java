package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.mappers.ZipCode;
import com.nartan.ba.resource.service.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/zipCode/")
public class ZipCodeController {

  @Autowired
  private ZipCodeService zipCodeService;

  @GetMapping("/showZipCodes")
  public List<ZipCode> findZipCodes(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("zipCode"));

    List<ZipCode> zipCodes = zipCodeService.findAll(paging);

    return zipCodes;
  }

  @GetMapping("/showAllZipCodes")
  public List<ZipCode> findZipCodes() {

    return zipCodeService.findAll();
  }

  @GetMapping("/findbyZipCode/{zipCode}")
  public List<ZipCode> findByZipCode(@PathVariable("zipCode") String zipCode) {

    return zipCodeService.findByZipCode(zipCode);
  }

  @GetMapping("/findbyStatus/{status}")
  public List<ZipCode> findByStatus(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @PathVariable("status") int status) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("zipCode"));

    List<ZipCode> zipCodes = zipCodeService.findByStatus(paging, status);

    return zipCodes;
  }

  @GetMapping("/findbyNeighborhood/{neighborhood}")
  public List<ZipCode> findByNeighborhood(@PathVariable("neighborhood") String neighborhood) {
    return zipCodeService.findByNeighborhood(neighborhood);
  }

  @GetMapping("/findbyMunicipalityId/{municipalityId}")
  public List<ZipCode> findByCityId(@PathVariable("cityId") int cityId) {
    return zipCodeService.findByCityId(cityId);
  }

  @GetMapping("/findbyStateId/{stateId}")
  public List<ZipCode> findByStateId(@PathVariable("stateId") int stateId) {
    return zipCodeService.findByStateId(stateId);
  }

  @GetMapping("/findbyCountryId/{countryId}")
  public List<ZipCode> findByCountryId(@PathVariable("countryId") int countryId) {
    return zipCodeService.findByCountryId(countryId);
  }


  @PostMapping(path = "/add")
  public void addZipCode(@RequestBody ZipCode zipCode) {
    zipCodeService.addZipCode(zipCode);
  }

  @PostMapping(path = "/update")
  public void updateZipCode(@RequestBody ZipCode zipCode) {
    zipCodeService.updateZipCode(zipCode);
  }
}
