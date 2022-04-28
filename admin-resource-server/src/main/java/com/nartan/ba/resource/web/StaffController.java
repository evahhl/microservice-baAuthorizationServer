package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.Staff;
import com.nartan.ba.resource.service.StaffService;
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
@RequestMapping(value = "/staff")
public class StaffController {

  @Autowired
  private StaffService staffService;

  @GetMapping("/showStaff")
  public List<Staff> findStaffs(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("staffId"));

    List<Staff> buildings = staffService.findAll(paging);

    return buildings;
  }

  @GetMapping("/findStaffbyId/{staffId}")
  public Optional<Staff> findStaffbyId(@PathVariable("staffId") int staffId) {

    Optional<Staff> building = staffService.findById(staffId);

    return building;
  }

  @PostMapping(path = "/add")
  public void addStaff(@RequestBody Staff building) {

    staffService.add(building);
  }

  @GetMapping(path = "/delete/{staffId}")
  public void deleteStaff(@PathVariable("staffId") int staffId) {
    Optional<Staff> staff = staffService.findById(staffId);
    if (staff.isEmpty()) {
      System.out.println("deleteStaff vacio, no hay nada que borrar");
    } else {
      staff.get().setStatus(0);
      staffService.delete(staff.get());
      System.out.println("deleteStaff registro borrado " + staff.get().getStaffId());
    }

  }
}
