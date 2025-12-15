package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.ExpenseType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseTypeService {
    private List<ExpenseType> expenseTypeList;

    public ExpenseTypeService(){
        expenseTypeList = new ArrayList<>();
        ExpenseType expenseType1 = new ExpenseType( 1, "Wallmart Grocery");
        ExpenseType expenseType2 = new ExpenseType( 2, "Suvidha Grocery");
        ExpenseType expenseType3 = new ExpenseType( 3, "Rakesh Guitar Class");
        ExpenseType expenseType4 = new ExpenseType( 4, "Purvi Swimming Class");
        ExpenseType expenseType5 = new ExpenseType( 5, "Kavya Swimming Class");
        ExpenseType expenseType6 = new ExpenseType( 6, "Purvi Karate Class");
        ExpenseType expenseType7 = new ExpenseType( 7, "Kavya Karate Class");
        ExpenseType expenseType8 = new ExpenseType( 8, "Purvi Math Class");
        ExpenseType expenseType9 = new ExpenseType( 9, "Purvi Hindi Class");
        ExpenseType expenseType10 = new ExpenseType( 10, "Kavya Hindi Class");
        expenseTypeList.addAll(Arrays.asList(expenseType1,expenseType2, expenseType3, expenseType4,
                expenseType5, expenseType6, expenseType7, expenseType8, expenseType9, expenseType10));
    }
    public Optional<Country> getExpenseType(Integer id){
        Optional optional = Optional.empty();
        for (ExpenseType expenseType: expenseTypeList){
            if(id == expenseType.getId()){
                optional = Optional.of(expenseType);
                return optional;
            }
        }
        return optional;
    }
}
