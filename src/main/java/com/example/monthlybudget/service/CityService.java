package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.City;
import com.example.monthlybudget.repository.CityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CityService {
    private List<City> cityList;
    private final CityRepository cityRepository;
    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Optional getCity(Long id, Long countryId, Long stateId) {
        Optional<Object> optional = Optional.empty();
        for (City city : cityRepository.findAll()) {
            if (Objects.equals(id, city.getId()) && Objects.equals(countryId, city.getCountryId())
                    && Objects.equals(stateId, city.getStateId())) {
                optional = Optional.of(city);
                return optional;
            }
        }
        return optional;
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public void addCity(City city) {
        System.out.println(city);
        cityRepository.save(city);
    }

    @Transactional
    public void updateCity(City city) {

        City existingCity = cityRepository.findById(city.getId())
                .orElseThrow(() ->
                        new RuntimeException("State not found with id: " + city.getId())
                );

        existingCity.setName(city.getName());
        existingCity.setCountryId(city.getCountryId());
        existingCity.setStateId(city.getStateId());
        cityRepository.save(existingCity);
    }

    @Transactional
    public void deleteCity(Long id) {
        cityRepository.findById(id)
                .ifPresentOrElse(
                        cityRepository::delete,
                        () -> {
                            throw new RuntimeException("City not found with id: " + id);
                        }
                );
    }
}
