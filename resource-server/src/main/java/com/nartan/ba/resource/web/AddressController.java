package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.Address;
import com.nartan.ba.resource.service.AddressService;
import com.nartan.ba.resource.exception.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author evahhl
 */
@RestController
@RequestMapping(value = "/address")
public class AddressController {

  @Autowired
  private AddressService addressService;

  @GetMapping("/show/{addressId}")
  public Address findAddressById(@PathVariable("addressId") int addressId) {

    return addressService.findById(addressId)
        .orElseThrow(() -> new PostNotFoundException(""));
  }

  @PostMapping(path = "/add")
  public void addAddress(@RequestBody Address address) {

    addressService.add(address);
  }

  @PostMapping(path = "/delete/{addressId}")
  public void deleteAddress(@PathVariable("addressId") int addressId) {
    addressService.deleteById(addressId);
  }
}
