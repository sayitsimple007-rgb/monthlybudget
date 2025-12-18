package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.State;
import com.example.monthlybudget.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CountryService {

    private List<Country> countryList;
    private final CountryRepository countryRepository;
    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Optional getCountry(Long id) {
        Optional<Object> optional = Optional.empty();
        for (Country country : countryRepository.findAll()) {
            if (Objects.equals(id, country.getId())) {
                optional = Optional.of(country);
                return optional;
            }
        }
        return optional;
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public void addCountry(Country country) {
        System.out.println(country);
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(Country country) {
        Country existingCountry = countryRepository.findById(country.getId())
                .orElseThrow(() ->
                        new RuntimeException("State not found with id: " + country.getId())
                );
        existingCountry.setName(country.getName());
        countryRepository.save(existingCountry);
    }

    @Transactional
    public void deleteCountry(Long id) {
        countryRepository.findById(id)
                .ifPresentOrElse(
                        countryRepository::delete,
                        () -> {
                            throw new RuntimeException("Country not found with id: " + id);
                        }
                );
    }
}
