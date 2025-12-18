package com.example.monthlybudget.api.controller;
import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping("/countries/{id}")
    public Country getCountry(@PathVariable Long id){
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

    @PostMapping("/countries")
    public void addCountry(@RequestBody Country country){
        System.out.println(country);
        countryService.addCountry(country);
    }

    @PutMapping("/countries/{id}")
    public void updateCountry(@PathVariable Long id, @RequestBody Country country){
        System.out.println(country);
        countryService.updateCountry(id, country);
    }

    @DeleteMapping("/countries/{id}")
    public void deleteCountry(@PathVariable Long id){
        System.out.println(id);
        countryService.deleteCountry(id);
    }
}
