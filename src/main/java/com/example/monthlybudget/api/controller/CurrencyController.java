package com.example.monthlybudget.api.controller;
import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.Currency;
import com.example.monthlybudget.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/currencies")
    public List<Currency> getCurrencies(){
        return currencyService.getCurrencies();
    }

    @PostMapping("/currency")
    public Currency addCurrency(@RequestBody Currency currency){
        System.out.println(currency);
        currencyService.addCurrency(currency);
        return currency;
    }
}
