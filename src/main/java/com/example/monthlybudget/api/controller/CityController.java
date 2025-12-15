package com.example.monthlybudget.api.controller;

import com.example.monthlybudget.api.model.City;
import com.example.monthlybudget.api.model.Expense;
import com.example.monthlybudget.api.model.State;
import com.example.monthlybudget.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping("/city")
    public City getCity(@RequestParam Integer id, @RequestParam Integer countryId
            , @RequestParam Integer stateId) {
        Optional city = cityService.getCity(id, countryId, stateId);
        if (city.isPresent()) {
            return (City) city.get();
        }
        return null;
    }

    @GetMapping("/cities")
    public List<City> getCities(){
        return cityService.getCities();
    }
}
