package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.Management;
import com.nartan.ba.resource.service.ManagementService;
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
@RequestMapping(value = "/management")
public class ManagementController {

  @Autowired
  private ManagementService managementService;

  @GetMapping("/showManagements")
  public List<Management> findManagements(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("managementId"));

    List<Management> managements = managementService.findAll(paging);

    return managements;
  }

  @GetMapping("/findManagementbyId/{managementId}")
  public Optional<Management> findManagementbyId(@PathVariable("managementId") int managementId) {

    Optional<Management> management = managementService.findById(managementId);

    return management;
  }

  @PostMapping(path = "/add")
  public void addManagement(@RequestBody Management management) {

    managementService.add(management);
  }

  @GetMapping(path = "/delete/{managementId}")
  public void deleteManagement(@PathVariable("managementId") int managementId) {
    Optional<Management> management = managementService.findById(managementId);
    if (management.isEmpty()) {
      System.out.println("deleteManagement vacio, no hay nada que borrar");
    } else {
      management.get().setStatus(0);
      managementService.delete(management.get());
      System.out.println("deleteManagement registro borrado " + management.get().getManagementId());
    }
  }
}
