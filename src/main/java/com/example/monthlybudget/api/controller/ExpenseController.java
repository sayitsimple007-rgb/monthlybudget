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

    @GetMapping("/expenses/{id}")
    public Expense getExpense(@PathVariable Long id) {
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

    @PostMapping("/expenses")
    public void addExpense(@RequestBody Expense expense) {
        System.out.println(expense);
        expenseService.addExpense(expense);
    }

    @PutMapping("/expenses/{id}")
    public void updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        System.out.println(expense);
        expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable Long id) {
        System.out.println(id);
        expenseService.deleteExpense(id);
    }
}
