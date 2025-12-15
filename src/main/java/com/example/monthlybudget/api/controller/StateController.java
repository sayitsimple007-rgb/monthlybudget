package com.example.monthlybudget.api.controller;

import com.example.monthlybudget.api.model.Income;
import com.example.monthlybudget.api.model.State;
import com.example.monthlybudget.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StateController {
    private StateService stateService;

    @Autowired
    public StateController(StateService stateService){
        this.stateService = stateService;
    }

    @GetMapping("/state")
    public State getState(@RequestParam Integer id, @RequestParam Integer countryId){
        Optional state = stateService.getState(id, countryId);
        if(state.isPresent()){
            return (State) state.get();
        }
        return null;
    }

    @GetMapping("/states")
    public List<State> getStates(){
        return stateService.getStates();
    }
}
