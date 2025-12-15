package com.example.monthlybudget.api.controller;
import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.ExpenseType;
import com.example.monthlybudget.api.model.Income;
import com.example.monthlybudget.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IncomeController {
    private IncomeService incomeService;

    @Autowired
    public IncomeController(IncomeService incomeService){
        this.incomeService = incomeService;
    }

    @GetMapping("/income")
    public Income getIncome(@RequestParam Integer id){
        Optional income = incomeService.getIncome(id);
        if(income.isPresent()){
            return (Income) income.get();
        }
        return null;
    }

    @GetMapping("/incomes")
    public List<Income> getIncomes(){
        return incomeService.getIncomes();
    }

    @PostMapping("/income")
    public Income addIncome(@RequestBody Income income){
        System.out.println(income);
        incomeService.addIncome(income);
        return income;
    }

    @PutMapping("/income")
    public Income updateIncome(@RequestBody Income income){
        System.out.println(income);
        incomeService.updateIncome(income);
        return income;
    }
}
