package com.example.monthlybudget.api.controller;

import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.Currency;
import com.example.monthlybudget.api.model.Expense;
import com.example.monthlybudget.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/expenses")
    public List<Expense> getExpenses(){
        return expenseService.getExpenses();
    }

    @PostMapping("/expense")
    public Expense addExpense(@RequestBody Expense expense){
        System.out.println(expense);
        expenseService.addExpense(expense);
        return expense;
    }

    @PutMapping("/expense")
    public Expense updateExpense(@RequestBody Expense expense){
        System.out.println(expense);
        expenseService.updateExpense(expense);
        return expense;
    }
}
