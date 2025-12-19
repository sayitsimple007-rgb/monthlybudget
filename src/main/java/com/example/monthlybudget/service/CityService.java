package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.City;
import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.State;
import com.example.monthlybudget.dto.CityRequest;
import com.example.monthlybudget.dto.CityResponse;
import com.example.monthlybudget.dto.CurrencyResponse;
import com.example.monthlybudget.repository.CityRepository;
import com.example.monthlybudget.repository.CountryRepository;
import com.example.monthlybudget.repository.StateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CityService {
    private List<City> cityList;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    @Autowired
    public CityService(CityRepository cityRepository,
                       CountryRepository countryRepository,
                       StateRepository stateRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
    }

    public Optional getCity(Long id, Long countryId, Long stateId) {
        Optional<Object> optional = Optional.empty();
        for (City city : cityRepository.findAll()) {
            if (Objects.equals(id, city.getId()) && Objects.equals(countryId, city.getCountry())
                    && Objects.equals(stateId, city.getState())) {
                optional = Optional.of(city);
                return optional;
            }
        }
        return optional;
    }

    public List<CityResponse> getCities() {
        return cityRepository.findAll()
                .stream()
                .map(c -> new CityResponse(
                        c.getId(),
                        c.getName(),
                        c.getCountry().getId(),
                        c.getCountry().getName(),
                        c.getState().getId(),
                        c.getState().getName()
                ))
                .toList();
    }
    @Transactional
    public void addCity(CityRequest cityRequest) {
        System.out.println(cityRequest);
        Country country = countryRepository.findById(cityRequest.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));
        State state = stateRepository.findById(cityRequest.getStateId())
                .orElseThrow(() -> new RuntimeException("Country not found"));
        City city = new City();
        city.setCountry(country);
        city.setState(state);
        city.setName(cityRequest.getName());
        City saved = cityRepository.save(city);
        ResponseEntity.ok(saved);
    }

    @Transactional
    public void updateCity(Long id, CityRequest cityRequest) {
        System.out.println(cityRequest);
        City existingCity = cityRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("City not found with id: " + id)
                );

        Country country = countryRepository.findById(cityRequest.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));

        State state = stateRepository.findById(cityRequest.getStateId())
                .orElseThrow(() -> new RuntimeException("State not found"));
        System.out.println(state);
        existingCity.setName(cityRequest.getName());
        existingCity.setCountry(country);
        existingCity.setState(state);
        City saved = cityRepository.save(existingCity);
        System.out.println(saved);

        ResponseEntity.ok(saved);
        System.out.println("hello");
    }

    @Transactional
    public void deleteCity(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id: " + id));
        cityRepository.delete(city);
    }
}
