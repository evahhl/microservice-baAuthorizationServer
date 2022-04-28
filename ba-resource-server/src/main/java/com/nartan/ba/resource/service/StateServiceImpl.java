package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.State;
import com.nartan.ba.resource.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StateServiceImpl implements StateService {

  @Autowired
  private StateRepository repository;

  @Override
  public List<State> findAll(Pageable paging) {

    Page<State> pagedResult = repository.findAll(paging);
    System.out.println("Total pages: " + pagedResult.getTotalPages());

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<State>();
    }
  }

  @Override
  public State findbyStateId(int stateId) {

    return repository.findbyStateId(stateId);
  }

  @Override
  public State findbyStateName(String stateName) {

    return repository.findbyStateName(stateName);
  }

  @Override
  public List<State> findbyStatus(int status) {

    List<State> states = repository.findbyStatus(status);

    return states;
  }


  @Override
  public void addState(State state) {
    repository.save(state);
  }
}