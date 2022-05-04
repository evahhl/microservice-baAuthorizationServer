package com.nartan.ba.resource.web;

import com.nartan.ba.resource.model.mappers.State;
import com.nartan.ba.resource.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/state")
public class StateController {

  @Autowired
  private StateService stateService;


  @GetMapping("/showStates")
  public List<State> findStates(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("stateId"));

    List<State> states = stateService.findAll(paging);

    return states;
  }

  @GetMapping("/findbyState/{stateId}")
  public State findbyState(@PathVariable("stateId") int stateId) {

    return stateService.findbyStateId(stateId);
  }

  @PostMapping("/findbyStateName")
  public State findbyStateName(@RequestBody State state) {

    return stateService.findbyStateName(state.getStateName());
  }

  @GetMapping("/findbyStatus/{status}")
  public List<State> findbyStatus(@PathVariable("status") int status) {

    return stateService.findbyStatus(status);
  }


  @PostMapping(path = "/add")
  public void addState(@RequestBody State state) {

    stateService.addState(state);
  }
}
