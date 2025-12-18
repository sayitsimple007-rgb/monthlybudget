package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.City;
import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.Currency;
import com.example.monthlybudget.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private List<Country> countryList;
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }
    public Optional<Country> getCountry(Integer id){
        Optional optional = Optional.empty();
        for (Country country: countryRepository.findAll()){
            if(id == country.getId()){
                optional = Optional.of(country);
                return optional;
            }
        }
        return optional;
    }

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    public Country addCountry(Country country){
        System.out.println(country);
        return countryRepository.save(country);
    }

    public Country updateCountry(Country country){
        int index = 0;
        System.out.println(country);
        for (int i=0;i<countryList.size();i++){
            if(countryList.get(i).getId() == country.getId())
                index = i;
        }
        countryList.set(index, country);
        return country;
    }

    public int deleteCountry(int id){
        int index = 0;
        System.out.println(id);
        for (int i=0;i<countryList.size();i++){
            if(countryList.get(i).getId() == id)
                index = i;
        }
        countryList.remove(index);
        return index;
    }
}
