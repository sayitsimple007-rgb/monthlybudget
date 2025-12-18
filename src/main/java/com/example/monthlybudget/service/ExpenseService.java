package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.Country;
import com.example.monthlybudget.api.model.Expense;
import com.example.monthlybudget.api.model.ExpenseType;
import com.example.monthlybudget.api.model.State;
import com.example.monthlybudget.repository.CountryRepository;
import com.example.monthlybudget.repository.ExpenseRepository;
import com.example.monthlybudget.repository.ExpenseTypeRepository;
import com.example.monthlybudget.repository.StateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final ExpenseTypeRepository expenseTypeRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository,
                          CountryRepository countryRepository,
                          StateRepository stateRepository,
                          ExpenseTypeRepository expenseTypeRepository) {
        this.expenseRepository = expenseRepository;
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
        this.expenseTypeRepository = expenseTypeRepository;
    }

    public Optional getExpense(Long id) {
        Optional<Object> optional = Optional.empty();
        for (Expense Expense : expenseRepository.findAll()) {
            if (Objects.equals(id, Expense.getId())) {
                optional = Optional.of(Expense);
                return optional;
            }
        }
        return optional;
    }

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    @Transactional
    public void addExpense(Expense expense) {
        System.out.println(expense);
        Country country = countryRepository.findById(expense.getCountry().getId())
                .orElseThrow(() -> new RuntimeException("Country not found"));

        State state = stateRepository.findById(expense.getState().getId())
                .orElseThrow(() -> new RuntimeException("State not found"));

        ExpenseType expenseType = expenseTypeRepository.findById(expense.getExpenseType().getId())
                .orElseThrow(() -> new RuntimeException("ExpenseType not found"));

        expense.setCountry(country);
        expense.setState(state);
        expense.setExpenseType(expenseType);

        expenseRepository.save(expense);
    }

    @Transactional
    public void updateExpense(Expense expense) {
        Expense existingExpene = expenseRepository.findById(expense.getId())
                .orElseThrow(() ->
                        new RuntimeException("Expense not found with id: " + expense.getId())
                );

        existingExpene.setName(expense.getName());
        existingExpene.setAmountPaid(expense.getAmountPaid());
        existingExpene.setExpenseType(expense.getExpenseType());
        existingExpene.setCountry(expense.getCountry());
        existingExpene.setState(expense.getState());
        expenseRepository.save(existingExpene);
    }

    @Transactional
    public void deleteExpense(Long id) {
        expenseRepository.findById(id)
                .ifPresentOrElse(
                        expenseRepository::delete,
                        () -> {
                            throw new RuntimeException("Expense not found with id: " + id);
                        }
                );
    }
}
