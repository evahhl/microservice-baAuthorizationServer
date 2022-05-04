package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.mappers.Parking;
import com.nartan.ba.resource.service.ParkingService;
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
@RequestMapping(value = "/parking")
public class ParkingController {

  @Autowired
  private ParkingService parkingService;

  @GetMapping("/showParkings")
  public List<Parking> findParkings(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("parkingId"));

    List<Parking> buildings = parkingService.findAll(paging);

    return buildings;
  }

  @GetMapping("/findParkingbyId/{parkingId}")
  public Optional<Parking> findParkingbyId(@PathVariable("parkingId") int parkingId) {

    Optional<Parking> building = parkingService.findById(parkingId);

    return building;
  }

  @PostMapping(path = "/add")
  public void addParking(@RequestBody Parking building) {

    parkingService.add(building);
  }

  @GetMapping(path = "/delete/{parkingId}")
  public void deleteParking(@PathVariable("parkingId") int parkingId) {
    Optional<Parking> parking = parkingService.findById(parkingId);
    if (parking.isEmpty()) {
      System.out.println("deleteParking vacio, no hay nada que borrar");
    } else {
      parking.get().setStatus(0);
      parkingService.delete(parking.get());
      System.out.println("deleteParking registro borrado " + parking.get().getId());
    }
  }
}
