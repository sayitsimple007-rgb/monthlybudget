package com.example.monthlybudget.api.controller;
import com.example.monthlybudget.api.model.Income;
import com.example.monthlybudget.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
