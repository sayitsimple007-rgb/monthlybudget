package com.example.monthlybudget.repository;

import com.example.monthlybudget.api.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
