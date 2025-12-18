package com.example.monthlybudget.api.controller;
import com.example.monthlybudget.api.model.ExpenseType;
import com.example.monthlybudget.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ExpenseTypeController {
    private final ExpenseTypeService expenseTypeService;

    @Autowired
    public ExpenseTypeController(ExpenseTypeService expenseTypeService){
        this.expenseTypeService = expenseTypeService;
    }

    @GetMapping("/expenseTypes/{id}")
    public ExpenseType getExpenseType(@RequestParam Long id){
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

    @PostMapping("/expenseTypes")
    public void addExpenseType(@RequestBody ExpenseType expenseType){
        System.out.println(expenseType);
        expenseTypeService.addExpenseType(expenseType);
    }

    @PutMapping("/expenseTypes/{id}")
    public void updateExpenseType(@PathVariable Long id, @RequestBody ExpenseType expenseType){
        System.out.println(expenseType);
        expenseTypeService.updateExpenseType(id, expenseType);
    }

    @DeleteMapping("/expenseTypes/{id}")
    public void deleteExpenseType(@PathVariable Long id){
        System.out.println(id);
        expenseTypeService.deleteExpenseType(id);
    }
}
