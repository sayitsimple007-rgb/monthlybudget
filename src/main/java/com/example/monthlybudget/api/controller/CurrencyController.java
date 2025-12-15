package com.example.monthlybudget.api.controller;
import com.example.monthlybudget.api.model.Currency;
import com.example.monthlybudget.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CurrencyController {
    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    @GetMapping("/currency")
    public Currency getCurrency(@RequestParam Integer id){
        Optional currency = currencyService.getCurrency(id);
        if(currency.isPresent()){
            return (Currency) currency.get();
        }
        return null;
    }
}
