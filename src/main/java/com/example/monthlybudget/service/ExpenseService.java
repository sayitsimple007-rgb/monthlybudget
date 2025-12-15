package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private List<Expense> expenseList;

    @Autowired
    public ExpenseService(CountryService countryService,
                          StateService stateService,
                          ExpenseTypeService expenseTypeService){
        expenseList = new ArrayList<>();
        Expense expense1 = new Expense( 1, "Wallmart Grocery",
                100,countryService.getCountry(2),stateService.getState(1, 2),
                expenseTypeService.getExpenseType(1));
        expenseList.addAll(Arrays.asList(expense1));
    }
    public Optional<Expense> getExpense(Integer id){
        Optional optional = Optional.empty();
        for (Expense Expense: expenseList){
            if(id == Expense.getId()){
                optional = Optional.of(Expense);
                return optional;
            }
        }
        return optional;
    }

    public List<Expense> getExpenses(){
        return expenseList;
    }
}
