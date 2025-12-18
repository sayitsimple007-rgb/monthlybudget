package com.example.monthlybudget.service;
import com.example.monthlybudget.api.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private List<Expense> expenseList;

    @Autowired
    public ExpenseService(CountryService countryService,
                          StateService stateService,
                          ExpenseTypeService expenseTypeService){
        expenseList = new ArrayList<>();
        Expense expense1 = new Expense( 1, "Wallmart Grocery",
                100,countryService.getCountry(2),stateService.getState(1, 2),
                expenseTypeService.getExpenseType(1));
        expenseList.addAll(Arrays.asList(expense1));
    }
    public Optional<Expense> getExpense(Integer id){
        Optional optional = Optional.empty();
        for (Expense Expense: expenseList){
            if(id == Expense.getId()){
                optional = Optional.of(Expense);
                return optional;
            }
        }
        return optional;
    }

    public List<Expense> getExpenses(){
        return expenseList;
    }

    public Expense addExpense(Expense expense){
        System.out.println(expense);
        expenseList.add(expense);
        return expense;
    }

    public Expense updateExpense(Expense expense){
        int index = 0;
        System.out.println(expense);
        for (int i=0;i<expenseList.size();i++){
            if(expenseList.get(i).getId() == expense.getId())
                index = i;
        }
        expenseList.set(index, expense);
        return expense;
    }

    public int deleteExpense(int id){
        int index = 0;
        System.out.println(id);
        for (int i=0;i<expenseList.size();i++){
            if(expenseList.get(i).getId() == id)
                index = i;
        }
        expenseList.remove(index);
        return index;
    }
}
