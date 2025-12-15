package com.example.monthlybudget.api.controller;

import com.example.monthlybudget.api.model.City;
import com.example.monthlybudget.api.model.Expense;
import com.example.monthlybudget.api.model.ExpenseType;
import com.example.monthlybudget.api.model.State;
import com.example.monthlybudget.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/city")
    public City addCity(@RequestBody City city){
        System.out.println(city);
        cityService.addCity(city);
        return city;
    }

    @PutMapping("/city")
    public City updateCity(@RequestBody City city){
        System.out.println(city);
        cityService.updateCity(city);
        return city;
    }

    @DeleteMapping("/cities/{id}")
    public int deleteCity(@PathVariable int id){
        System.out.println(id);
        cityService.deleteCity(id);
        return id;
    }
}
