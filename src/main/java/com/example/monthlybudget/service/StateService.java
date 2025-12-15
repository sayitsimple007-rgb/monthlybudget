package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.Income;
import com.example.monthlybudget.api.model.State;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    private List<State> stateList;

    public StateService(){
        stateList = new ArrayList<>();
        State state1 = new State(1, "North Carolina", 2);
        State state2 = new State(2, "Maharashtra", 1);
        stateList.addAll(Arrays.asList(state1,state2));
    }

    public Optional<State> getState(Integer id, Integer countryId){
        //return stateList.stream().filter(state -> id == state.getId() && countryId == state.getCountryId())
                //.findFirst().get();
        Optional optional = Optional.empty();
        for (State state:stateList){
            if(id == state.getId() && countryId == state.getCountryId()){
                optional = Optional.of(state);
                return optional;
            }
        }
        return optional;
    }

    public List<State> getStates(){
        return stateList;
    }

    public State addState(State state){
        System.out.println(state);
        stateList.add(state);
        return state;
    }
}
