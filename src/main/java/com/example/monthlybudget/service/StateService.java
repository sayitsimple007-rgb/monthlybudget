package com.example.monthlybudget.service;

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
        State state1 = new State(1, "North Carolina");
        State state2 = new State(2, "Maharashtra");
        stateList.addAll(Arrays.asList(state1,state2));
    }

    public Optional<State> getState(Integer id){
        Optional optional = Optional.empty();
        for (State state:stateList){
            if(id == state.getId()){
                optional = Optional.of(state);
                return optional;
            }
        }
        return optional;
    }
}
