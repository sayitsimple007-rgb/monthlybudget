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

    @GetMapping("/states/{id}")
    public State getState(@PathVariable Long id, @RequestParam Long countryId){
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

    @PostMapping("/states")
    public void addState(@RequestBody State state){
        System.out.println(state);
        stateService.addState(state);
    }

    @PutMapping("/states")
    public void updateState(@PathVariable Long id, @RequestBody State state){
        System.out.println(state);
        stateService.updateState(id, state);
    }

    @DeleteMapping("/states/{id}")
    public void deleteState(@PathVariable Long id){
        System.out.println(id);
        stateService.deleteState(id);
    }
}
