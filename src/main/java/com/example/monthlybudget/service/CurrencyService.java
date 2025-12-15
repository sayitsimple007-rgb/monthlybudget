package com.example.monthlybudget.service;
import com.example.monthlybudget.api.model.Country;
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

    public List<Currency> getCurrencies(){
        return currencyList;
    }

    public Currency addCurrency(Currency currency){
        System.out.println(currency);
        currencyList.add(currency);
        return currency;
    }

    public Currency updateCurrency(Currency currency){
        int index = 0;
        System.out.println(currency);
        for (int i=0;i<currencyList.size();i++){
            if(currencyList.get(i).getId() == currency.getId())
                index = i;
        }
        currencyList.set(index, currency);
        return currency;
    }

    public int deleteCurrency(int id){
        int index = 0;
        System.out.println(id);
        for (int i=0;i<currencyList.size();i++){
            if(currencyList.get(i).getId() == id)
                index = i;
        }
        currencyList.remove(index);
        return index;
    }
}
