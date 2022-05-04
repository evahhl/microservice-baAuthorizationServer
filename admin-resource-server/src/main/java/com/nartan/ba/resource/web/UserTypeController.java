package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.mappers.UserType;
import com.nartan.ba.resource.service.UserTypeService;
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
@RequestMapping(value = "/userType")
public class UserTypeController {

  @Autowired
  private UserTypeService userTypeService;

  @GetMapping("/showUserType")
  public List<UserType> findBuildings(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("userTypeId"));

    List<UserType> userType = userTypeService.findAll(paging);

    return userType;
  }


  @GetMapping("/showUserTypebyId/{userTypeId}")
  public Optional<UserType> findUserTypebyId(@PathVariable("userTypeId") int userTypeId) {

    Optional<UserType> userType = userTypeService.findById(userTypeId);

    return userType;
  }

  @PostMapping(path = "/add")
  public void addUserType(@RequestBody UserType userType) {

    userTypeService.add(userType);
  }

  @PostMapping(path = "/delete/{userTypeId}")
  public void deleteUserType(@PathVariable("userTypeId") int userTypeId) {
    userTypeService.deleteById(userTypeId);
  }
}
