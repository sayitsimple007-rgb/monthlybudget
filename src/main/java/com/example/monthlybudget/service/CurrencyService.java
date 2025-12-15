package com.example.monthlybudget.service;
import com.example.monthlybudget.api.model.Currency;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CurrencyService {
    private List<Currency> currencyList;

    public CurrencyService(){
        currencyList = new ArrayList<>();
        Currency currency1 = new Currency( 1, "Rs", 1);
        Currency currency2 = new Currency( 2, "$", 2);
        currencyList.addAll(Arrays.asList(currency1,currency2));
    }
    public Optional<Currency> getCurrency(Integer id){
        Optional optional = Optional.empty();
        for (Currency currency: currencyList){
            if(id == currency.getId()){
                optional = Optional.of(currency);
                return optional;
            }
        }
        return optional;
    }
}
