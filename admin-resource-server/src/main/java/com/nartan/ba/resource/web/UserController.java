package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.User;
import com.nartan.ba.resource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author evahhl
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService userService;


  private BCryptPasswordEncoder bCryptPasswordEncoder;

//  public UserController(BCryptPasswordEncoder bCryptPasswordEncoder) {
//    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//  }

  @GetMapping("/showUsers")
  public List<User> findUsers(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("userId"));

    List<User> buildings = userService.findAll(paging);

    return buildings;
  }

  @GetMapping("/findUserbyId/{userId}")
  public Optional<User> findUserbyId(@PathVariable("userId") int userId) {

    Optional<User> building = userService.findById(userId);

    return building;
  }

  @PostMapping(path = "/add")
  public void addUser(@RequestBody User user) {

    userService.add(user);
  }

  @GetMapping(path = "/delete/{userId}")
  public void deleteUser(@PathVariable("userId") int userId) {
    Optional<User> user = userService.findById(userId);
    if (user.isEmpty()) {
      System.out.println("deleteUser vacio, no hay nada que borrar");
    } else {
      user.get().setStatus(0);
      userService.delete(user.get());
      System.out.println("deleteUser registro borrado " + user.get().getId());
    }

  }
}