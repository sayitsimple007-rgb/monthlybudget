package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.City;
import com.example.monthlybudget.api.model.State;
import com.example.monthlybudget.repository.CityRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private List<City> cityList;
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public Optional<State> getCity(Long id, Long countryId, Long stateId){
        Optional optional = Optional.empty();
        for (City city:cityRepository.findAll()){
            if(id == city.getId() && countryId == city.getCountryId() && stateId == city.getStateId()){
                optional = Optional.of(city);
                return optional;
            }
        }
        return optional;
    }

    public List<City> getCities(){
        return cityRepository.findAll();
    }

    public City addCity(City city){
        System.out.println(city);
        return cityRepository.save(city);
    }

    public City updateCity(City city){
        int index = 0;
        System.out.println(city);
        for (int i=0;i<cityList.size();i++){
            if(cityList.get(i).getId() == city.getId())
                index = i;
        }
        cityList.set(index, city);
        return city;
    }

    public int deleteCity(int id){
        System.out.println(id);
        int index = 0;
        for (int i=0; i < cityList.size(); i++){
            if(cityList.get(i).getId() == id)
                index = i;
        }
        cityList.remove(index);
        return index;
    }
}
