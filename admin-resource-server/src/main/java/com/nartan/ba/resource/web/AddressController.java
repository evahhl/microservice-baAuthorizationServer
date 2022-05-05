package com.nartan.ba.resource.web;

import com.nartan.ba.resource.enums.ResultCode;
import com.nartan.ba.resource.model.JsonResponse;
import com.nartan.ba.resource.model.mappers.Address;
import com.nartan.ba.resource.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author evahhl
 */
@RestController
@RequestMapping(value = "/address")
public class AddressController {

  @Autowired
  private AddressService addressService;


  @GetMapping("/show/{addressId}")
  public JsonResponse findAddressbyId(final @PathVariable("addressId") int addressId)  {
      final Optional<Address> address = addressService.findById(addressId);
      final JsonResponse response = new JsonResponse();
      response.addObject("address", address.isPresent()?address.get(): new ArrayList<String>());
      response.setMessage("Address retrieved successfully");

      return response;
  }

  @PostMapping(path="/add")
  public JsonResponse addAddress(final @RequestBody @Valid Address address) {
      final JsonResponse response = new JsonResponse();
      try{
          Address newAddress = addressService.add(address);
          response.addObject("address", newAddress);
          response.setMessage("Address added successfully");
      }catch (Exception e){
          response.setMessage("");
          response.setResultCode(ResultCode.DATABASE_ERROR);
          response.setResultDesc(e.getMessage());
      }
      return response;
  }

  @PostMapping(path="/delete/{addressId}")
  public JsonResponse deleteAddress(@PathVariable("addressId") int addressId) {
      final JsonResponse response = new JsonResponse();
      try{
          addressService.deleteById(addressId);
          response.addObject("address", addressId);
          response.setMessage("Address deleted successfully");
      }catch (Exception e){
//          return new SQLException("Address with id: " + addressId);
          response.setMessage("");
          response.setResultCode(ResultCode.DATABASE_ERROR);
          response.setResultDesc(e.getMessage());
      }

      return response;
  }

}