package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.mappers.Country;
import com.nartan.ba.resource.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/country/")
public class CountryController {

  @Autowired
  private CountryService countryService;


  @GetMapping("/showCountries")
  public List<Country> findCountrys() {
    return (List<Country>) countryService.findAll();
  }

  @GetMapping("/findbyCountry/{country}")
  public Optional<Country> findbyCountry(@PathVariable("countryId") String countryId) {

    return countryService.findbyCountryId(countryId);
  }

  @GetMapping("/findbyCountryName/{countryName}")
  public Optional<Country> findbyCountryName(@PathVariable("countryName") String countryName) {

    return countryService.findbyCountryName(countryName);
  }

  @GetMapping("/findbyStatus/{status}")
  public Optional<Country> findbyStatus(@PathVariable("status") String status) {

    return countryService.findbyStatus(status);
  }


  @PostMapping(path = "/add")
  public void addCountry(@RequestBody Country country) {

    countryService.addCountry(country);
  }

  @PostMapping(path = "/update")
  public void updateCountry(@RequestBody Country country) {

    countryService.updateCountry(country);
  }
}