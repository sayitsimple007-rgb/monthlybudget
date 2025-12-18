package com.example.monthlybudget.repository;

import com.example.monthlybudget.api.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
