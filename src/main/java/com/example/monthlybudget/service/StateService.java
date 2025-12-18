package com.example.monthlybudget.service;
import com.example.monthlybudget.api.model.State;
import com.example.monthlybudget.repository.StateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StateService {
    private final StateRepository stateRepository;
    @Autowired
    public StateService(StateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    public Optional getState(Long id, Long countryId){
        Optional<Object> optional = Optional.empty();
        for (State state:stateRepository.findAll()){
            if(Objects.equals(id, state.getId()) && Objects.equals(countryId, state.getCountryId())){
                optional = Optional.of(state);
                return optional;
            }
        }
        return optional;
    }

    public List<State> getStates(){
        return stateRepository.findAll();
    }

    @Transactional
    public void addState(State state){
        System.out.println(state);
        stateRepository.save(state);
    }

    @Transactional
    public void updateState(State state) {

        State existingState = stateRepository.findById(state.getId())
                .orElseThrow(() ->
                        new RuntimeException("State not found with id: " + state.getId())
                );

        existingState.setName(state.getName());
        existingState.setCountryId(state.getCountryId());
        stateRepository.save(existingState);
    }

    @Transactional
    public void deleteState(Long id) {
        stateRepository.findById(id)
                .ifPresentOrElse(
                        stateRepository::delete,
                        () -> {
                            throw new RuntimeException("State not found with id: " + id);
                        }
                );
    }
}
