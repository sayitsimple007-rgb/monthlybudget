package com.example.monthlybudget.api.controller;
import com.example.monthlybudget.api.model.City;
import com.example.monthlybudget.dto.CityRequest;
import com.example.monthlybudget.dto.CityResponse;
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

    @GetMapping("/cities/{id}")
    public City getCity(@PathVariable Long id, @RequestParam Long countryId
            , @RequestParam Long stateId) {
        Optional city = cityService.getCity(id, countryId, stateId);
        if (city.isPresent()) {
            return (City) city.get();
        }
        return null;
    }

    @GetMapping("/cities")
    public List<CityResponse> getCities(){
        return cityService.getCities();
    }

    @PostMapping("/cities")
    public void addCity(@RequestBody CityRequest cityRequest){
        System.out.println(cityRequest);
        cityService.addCity(cityRequest);
    }

    @PutMapping("/cities/{id}")
    public void updateCity(@PathVariable Long id, @RequestBody CityRequest cityRequest){
        System.out.println(cityRequest);
        cityService.updateCity(id, cityRequest);
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable Long id){
        System.out.println(id);
        cityService.deleteCity(id);
    }
}
