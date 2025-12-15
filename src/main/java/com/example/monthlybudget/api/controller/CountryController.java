package com.example.monthlybudget.api.controller;

import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.Expense;
import com.example.monthlybudget.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CountryController {
    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping("/country")
    public Country getCountry(@RequestParam Integer id){
        Optional country = countryService.getCountry(id);
        if(country.isPresent()){
            return (Country) country.get();
        }
        return null;
    }

    @GetMapping("/countries")
    public List<Country> getCountries(){
        return countryService.getCountries();
    }

    @PostMapping("/country")
    public Country addCountry(@RequestBody Country country){
        System.out.println(country);
        countryService.addCountry(country);
        return country;
    }
}
