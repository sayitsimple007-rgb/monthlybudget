package com.example.monthlybudget.api.controller;
import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.Currency;
import com.example.monthlybudget.api.model.Expense;
import com.example.monthlybudget.api.model.ExpenseType;
import com.example.monthlybudget.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExpenseTypeController {
    private ExpenseTypeService expenseTypeService;

    @Autowired
    public ExpenseTypeController(ExpenseTypeService expenseTypeService){
        this.expenseTypeService = expenseTypeService;
    }

    @GetMapping("/expenseType")
    public ExpenseType getExpenseType(@RequestParam Integer id){
        Optional expenseType = expenseTypeService.getExpenseType(id);
        if(expenseType.isPresent()){
            return (ExpenseType) expenseType.get();
        }
        return null;
    }

    @GetMapping("/expenseTypes")
    public List<ExpenseType> getExpenseTypes(){
        return expenseTypeService.getExpenseTypes();
    }

    @PostMapping("/expenseType")
    public ExpenseType addExpenseType(@RequestBody ExpenseType expenseType){
        System.out.println(expenseType);
        expenseTypeService.addExpenseType(expenseType);
        return expenseType;
    }

    @PutMapping("/expenseType")
    public ExpenseType updateExpenseType(@RequestBody ExpenseType expenseType){
        System.out.println(expenseType);
        expenseTypeService.updateExpenseType(expenseType);
        return expenseType;
    }

    @DeleteMapping("/expenseTypes/{id}")
    public int deleteExpenseType(@PathVariable int id){
        System.out.println(id);
        expenseTypeService.deleteExpenseType(id);
        return id;
    }
}
