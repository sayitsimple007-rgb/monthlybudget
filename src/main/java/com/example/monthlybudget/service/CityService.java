package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.City;
import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.Expense;
import com.example.monthlybudget.api.model.State;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private List<City> cityList;

    public CityService(){
        cityList = new ArrayList<>();
        City city1 = new City(1, "Cary", 1, 1);
        City city2 = new City(2, "Pune", 2, 2);
        cityList.addAll(Arrays.asList(city1,city2));
    }

    public Optional<State> getCity(Integer id, Integer countryId, Integer stateId){
        Optional optional = Optional.empty();
        for (City city:cityList){
            if(id == city.getId() && countryId == city.getCountryId() && stateId == city.getStateId()){
                optional = Optional.of(city);
                return optional;
            }
        }
        return optional;
    }

    public List<City> getCities(){
        return cityList;
    }

    public City addCity(City city){
        System.out.println(city);
        cityList.add(city);
        return city;
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
}
