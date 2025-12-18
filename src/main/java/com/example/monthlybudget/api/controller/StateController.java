package com.example.monthlybudget.api.controller;
import com.example.monthlybudget.api.model.State;
import com.example.monthlybudget.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class StateController {
    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService){
        this.stateService = stateService;
    }

    @GetMapping("/state")
    public State getState(@RequestParam Long id, @RequestParam Long countryId){
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

    @PostMapping("/state")
    public void addState(@RequestBody State state){
        System.out.println(state);
        stateService.addState(state);
    }

    @PutMapping("/state")
    public void updateState(@RequestBody State state){
        System.out.println(state);
        stateService.updateState(state);
    }

    @DeleteMapping("/states/{id}")
    public void deleteState(@PathVariable Long id){
        System.out.println(id);
        stateService.deleteState(id);
    }
}
