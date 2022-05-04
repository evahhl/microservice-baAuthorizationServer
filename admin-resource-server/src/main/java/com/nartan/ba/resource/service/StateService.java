package com.nartan.ba.resource.service;

import com.nartan.ba.resource.model.mappers.State;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StateService {

  List<State> findAll(Pageable pageable);

  State findbyStateId(int stateId);

  State findbyStateName(String stateName);

  List<State> findbyStatus(int status);

  void addState(State state);
}
