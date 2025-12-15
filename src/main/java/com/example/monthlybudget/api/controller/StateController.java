package com.example.monthlybudget.api.controller;

import com.example.monthlybudget.api.model.State;
import com.example.monthlybudget.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StateController {
    private StateService stateService;

    @Autowired
    public StateController(StateService stateService){
        this.stateService = stateService;
    }

    @GetMapping("/state")
    public State getState(@RequestParam Integer id){
        Optional state = stateService.getState(id);
        if(state.isPresent()){
            return (State) state.get();
        }
        return null;
    }
}
