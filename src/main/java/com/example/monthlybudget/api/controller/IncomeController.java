package com.example.monthlybudget.api.controller;

import com.example.monthlybudget.api.model.Income;
import com.example.monthlybudget.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IncomeController {
    private final IncomeService incomeService;

    @Autowired
    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/incomes/{id}")
    public Income getIncome(@RequestParam Long id) {
        Optional income = incomeService.getIncome(id);
        if (income.isPresent()) {
            return (Income) income.get();
        }
        return null;
    }

    @GetMapping("/incomes")
    public List<Income> getIncomes() {
        return incomeService.getIncomes();
    }

    @PostMapping("/incomes")
    public void addIncome(@RequestBody Income income) {
        System.out.println(income);
        incomeService.addIncome(income);
    }

    @PutMapping("/incomes/{id}")
    public void updateIncome(@PathVariable Long id, @RequestBody Income income) {
        System.out.println(income);
        incomeService.updateIncome(id, income);
    }

    @DeleteMapping("/incomes/{id}")
    public void deleteIncome(@PathVariable Long id) {
        System.out.println(id);
        incomeService.deleteIncome(id);
    }
}
