package com.example.monthlybudget.api.controller;

import com.example.monthlybudget.api.model.Currency;
import com.example.monthlybudget.dto.CurrencyRequest;
import com.example.monthlybudget.dto.CurrencyResponse;
import com.example.monthlybudget.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CurrencyController {
    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currencies/{id}")
    public Currency getCurrency(@PathVariable Long id) {
        Optional currency = currencyService.getCurrency(id);
        if (currency.isPresent()) {
            return (Currency) currency.get();
        }
        return null;
    }

    @GetMapping("/currencies")
    public List<CurrencyResponse> getCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @PostMapping("/currencies")
    public void addCurrency(@RequestBody CurrencyRequest currencyRequest) {
        System.out.println(currencyRequest);
        currencyService.addCurrency(currencyRequest);
    }

    @PutMapping("/currencies/{id}")
    public void updateCurrency(@PathVariable Long id, @RequestBody Currency currency) {
        System.out.println(currency);
        currencyService.updateCurrency(id, currency);
    }

    @DeleteMapping("/currencies/{id}")
    public void deleteCurrency(@PathVariable Long id) {
        System.out.println(id);
        currencyService.deleteCurrency(id);
    }
}
