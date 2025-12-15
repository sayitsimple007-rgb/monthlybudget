package com.example.monthlybudget.api.controller;
import com.example.monthlybudget.api.model.ExpenseType;
import com.example.monthlybudget.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
