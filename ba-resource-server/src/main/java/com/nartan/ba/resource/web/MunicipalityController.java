package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.Municipality;
import com.nartan.ba.resource.service.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/municipality")
public class MunicipalityController {

  @Autowired
  private MunicipalityService municipalityService;


  @GetMapping("/showMunicipalities")
  public List<Municipality> findMunicipalities(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("municipalityId"));

    List<Municipality> municipality = municipalityService.findAll(paging);

    return municipality;
  }

  @GetMapping("/findbyMunicipalityId/{municipalityId}")
  public Municipality findbyMunicipalityId(@PathVariable("municipalityId") int municipalityId) {

    return municipalityService.findbyMunicipalityId(municipalityId);
  }

  @PostMapping("/findbyMunicipalityName")
  public List<Municipality> findbyMunicipalityName(@RequestBody Municipality municipality) {

    return municipalityService.findbyMunicipalityName(municipality.getMunicipalityName());
  }

  @GetMapping("/findbyStatus/{status}")
  public List<Municipality> findbyStatus(@PathVariable("status") int status,
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("municipalityId"));

    return municipalityService.findbyStatus(status, paging);
  }


  @PostMapping(path = "/add")
  public void addMunicipality(@RequestBody Municipality municipality) {

    municipalityService.addUpdateMunicipality(municipality);
  }

  @GetMapping(path = "/delete/{municipalityId}")
  public void deleteMunicipality(@PathVariable("countryId") int municipalityId) {
    Municipality municipality = municipalityService.findbyMunicipalityId(municipalityId);
    municipality.setStatus(0);
    municipalityService.addUpdateMunicipality(municipality);
  }
}
