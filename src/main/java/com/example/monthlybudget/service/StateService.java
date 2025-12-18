package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.Income;
import com.example.monthlybudget.api.model.State;
import com.example.monthlybudget.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    private List<State> stateList;
    private final StateRepository stateRepository;

    public StateService(StateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    public Optional<State> getState(Integer id, Integer countryId){
        Optional optional = Optional.empty();
        for (State state:stateRepository.findAll()){
            if(id == state.getId() && countryId == state.getCountryId()){
                optional = Optional.of(state);
                return optional;
            }
        }
        return optional;
    }

    public List<State> getStates(){
        return stateRepository.findAll();
    }

    public State addState(State state){
        System.out.println(state);
        return stateRepository.save(state);
    }

    public State updateState(State state){
        int index = 0;
        System.out.println(state);
        for (int i=0;i<stateList.size();i++){
            if(stateList.get(i).getId() == state.getId())
                index = i;
        }
        stateList.set(index, state);
        return state;
    }

    public int deleteState(int id){
        int index = 0;
        System.out.println(id);
        for (int i=0;i<stateList.size();i++){
            if(stateList.get(i).getId() == id)
                index = i;
        }
        stateList.remove(index);
        return index;
    }
}
