package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.mappers.UserApartment;
import com.nartan.ba.resource.service.UserApartmentService;
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
@RequestMapping(value = "/userApartment")
public class UserApartmentController {

  @Autowired
  private UserApartmentService userApartmentService;

  @GetMapping("/showUserApartment")
  public List<UserApartment> findUserApartments(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("userApartmentId"));

    List<UserApartment> buildings = userApartmentService.findAll(paging);

    return buildings;
  }

  @GetMapping("/findUserApartmentbyId/{userApartmentId}")
  public Optional<UserApartment> findUserApartmentbyId(
      @PathVariable("userApartmentId") int userApartmentId) {

    Optional<UserApartment> building = userApartmentService.findUserApartmentId(userApartmentId);

    return building;
  }

  @PostMapping(path = "/add")
  public void addUserApartment(@RequestBody UserApartment building) {

    userApartmentService.addUserApartment(building);
  }

  @GetMapping(path = "/delete/{userApartmentId}")
  public void deleteUserApartment(@PathVariable("userApartmentId") int userApartmentId) {
    userApartmentService.deleteUserApartment(userApartmentId);

  }
}
