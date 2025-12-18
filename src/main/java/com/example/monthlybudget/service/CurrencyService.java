package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.Currency;
import com.example.monthlybudget.repository.CountryRepository;
import com.example.monthlybudget.repository.CurrencyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository,
                           CountryRepository countryRepository) {
        this.currencyRepository = currencyRepository;
        this.countryRepository = countryRepository;
    }

    public Optional getCurrency(Long id) {
        Optional<Object> optional = Optional.empty();
        for (Currency currency : currencyRepository.findAll()) {
            if (Objects.equals(id, currency.getId())) {
                optional = Optional.of(currency);
                return optional;
            }
        }
        return optional;
    }

    public List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    @Transactional
    public void addCurrency(Currency currency) {
        System.out.println(currency);
        Country country = countryRepository.findById(currency.getCountry().getId())
                .orElseThrow(() -> new RuntimeException("Country not found"));
        currency.setName(currency.getName());
        currency.setCountry(country);
        Currency saved = currencyRepository.save(currency);
        ResponseEntity.ok(saved);
    }

    @Transactional
    public void updateCurrency(Currency currency) {
        Currency existingCurrency = currencyRepository.findById(currency.getId())
                .orElseThrow(() ->
                        new RuntimeException("Currency not found with id: " + currency.getId())
                );
        existingCurrency.setName(currency.getName());
        currencyRepository.save(existingCurrency);
    }

    @Transactional
    public void deleteCurrency(Long id) {
        currencyRepository.findById(id)
                .ifPresentOrElse(
                        currencyRepository::delete,
                        () -> {
                            throw new RuntimeException("Currency not found with id: " + id);
                        }
                );
    }
}
