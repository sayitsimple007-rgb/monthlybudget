package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.Currency;
import com.example.monthlybudget.dto.CurrencyRequest;
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
    public void addCurrency(CurrencyRequest currencyRequest) {
        System.out.println(currencyRequest);
        Country country = countryRepository.findById(currencyRequest.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));
        Currency currency = new Currency();
        currency.setCountry(country);
        currency.setName(currencyRequest.getName());
        Currency saved = currencyRepository.save(currency);
        ResponseEntity.ok(saved);
    }

    @Transactional
    public void updateCurrency(Long id, Currency currency) {
        Currency existingCurrency = currencyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Currency not found with id: " + id)
                );
        existingCurrency.setName(currency.getName());
        existingCurrency.setCountry(currency.getCountry());
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
