package com.example.monthlybudget.api.controller;

import com.example.monthlybudget.api.model.Expense;
import com.example.monthlybudget.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expense")
    public Expense getExpense(@RequestParam Long id) {
        Optional expense = expenseService.getExpense(id);
        if (expense.isPresent()) {
            return (Expense) expense.get();
        }
        return null;
    }

    @GetMapping("/expenses")
    public List<Expense> getExpenses() {
        return expenseService.getExpenses();
    }

    @PostMapping("/expense")
    public void addExpense(@RequestBody Expense expense) {
        System.out.println(expense);
        expenseService.addExpense(expense);
    }

    @PutMapping("/expense")
    public void updateExpense(@RequestBody Expense expense) {
        System.out.println(expense);
        expenseService.updateExpense(expense);
    }

    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable Long id) {
        System.out.println(id);
        expenseService.deleteExpense(id);
    }
}
