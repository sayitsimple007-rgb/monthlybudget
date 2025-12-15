package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private List<Country> countryList;

    public CountryService(){
        countryList = new ArrayList<>();
        Country country1 = new Country( 1, "India");
        Country country2 = new Country( 2, "USA");
        countryList.addAll(Arrays.asList(country1,country2));
    }
    public Optional<Country> getCountry(Integer id){
        Optional optional = Optional.empty();
        for (Country country: countryList){
            if(id == country.getId()){
                optional = Optional.of(country);
                return optional;
            }
        }
        return optional;
    }
}
