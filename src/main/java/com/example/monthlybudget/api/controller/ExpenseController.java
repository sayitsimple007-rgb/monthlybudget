package com.example.monthlybudget.api.controller;

import com.example.monthlybudget.api.model.Expense;
import com.example.monthlybudget.api.model.ExpenseType;
import com.example.monthlybudget.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ExpenseController {
    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping("/expense")
    public Expense getExpense(@RequestParam Integer id){
        Optional expense = expenseService.getExpense(id);
        if(expense.isPresent()){
            return (Expense) expense.get();
        }
        return null;
    }
}
