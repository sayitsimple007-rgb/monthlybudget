package com.example.monthlybudget.api.controller;
import com.example.monthlybudget.api.model.City;
import com.example.monthlybudget.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping("/city")
    public City getCity(@RequestParam Long id, @RequestParam Long countryId
            , @RequestParam Long stateId) {
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
    public void addCity(@RequestBody City city){
        System.out.println(city);
        cityService.addCity(city);
    }

    @PutMapping("/city")
    public void updateCity(@RequestBody City city){
        System.out.println(city);
        cityService.updateCity(city);
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable Long id){
        System.out.println(id);
        cityService.deleteCity(id);
    }
}
