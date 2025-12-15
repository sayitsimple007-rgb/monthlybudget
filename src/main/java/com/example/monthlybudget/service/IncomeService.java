package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.ExpenseType;
import com.example.monthlybudget.api.model.Income;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {
    private List<Income> incomeList;

    public IncomeService(){
        incomeList = new ArrayList<>();
        Income income1 = new Income( 1, "Fidelity - Bank of America", 1000);
        Income income2 = new Income( 2, "Fidelity - DCU", 1000);
        incomeList.addAll(Arrays.asList(income1,income2));
    }
    public Optional<Income> getIncome(Integer id){
        Optional optional = Optional.empty();
        for (Income income: incomeList){
            if(id == income.getId()){
                optional = Optional.of(income);
                return optional;
            }
        }
        return optional;
    }
}
