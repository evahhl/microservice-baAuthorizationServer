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
  public List<ZipCode> findbyZipCode(@PathVariable("zipCode") String zipCode) {

    return zipCodeService.findbyZipCode(zipCode);
  }

  @GetMapping("/findbyStatus/{status}")
  public List<ZipCode> findbyStatus(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @PathVariable("status") int status) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("zipCode"));

    List<ZipCode> zipCodes = zipCodeService.findbyStatus(paging, status);

    return zipCodes;
  }

  @GetMapping("/findbyNeighborhood/{neighborhood}")
  public List<ZipCode> findbyNeighborhood(@PathVariable("neighborhood") String neighborhood) {
    return zipCodeService.findbyNeighborhood(neighborhood);
  }

  @GetMapping("/findbyMunicipalityId/{municipalityId}")
  public List<ZipCode> findbyMunicipalityId(@PathVariable("municipalityId") int municipalityId) {
    return zipCodeService.findbyMunicipalityId(municipalityId);
  }

  @GetMapping("/findbyStateId/{stateId}")
  public List<ZipCode> findbyStateId(@PathVariable("stateId") int stateId) {
    return zipCodeService.findbyStateId(stateId);
  }

  @GetMapping("/findbyCountryId/{countryId}")
  public List<ZipCode> findbyCountryId(@PathVariable("countryId") int countryId) {
    return zipCodeService.findbyCountryId(countryId);
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
