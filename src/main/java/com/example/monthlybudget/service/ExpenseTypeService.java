package com.example.monthlybudget.service;

import com.example.monthlybudget.api.model.ExpenseType;
import com.example.monthlybudget.repository.ExpenseTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpenseTypeService {
    private final ExpenseTypeRepository expenseTypeRepository;
    @Autowired
    public ExpenseTypeService(ExpenseTypeRepository expenseTypeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }

    public Optional getExpenseType(Long id) {
        Optional<Object> optional = Optional.empty();
        for (ExpenseType expenseType : expenseTypeRepository.findAll()) {
            if (Objects.equals(id, expenseType.getId())) {
                optional = Optional.of(expenseType);
                return optional;
            }
        }
        return optional;
    }

    public List<ExpenseType> getExpenseTypes() {
        return expenseTypeRepository.findAll();
    }

    @Transactional
    public void addExpenseType(ExpenseType expenseType) {
        System.out.println(expenseType);
        expenseTypeRepository.save(expenseType);
    }

    @Transactional
    public void updateExpenseType(ExpenseType expenseType) {
        ExpenseType existingExpeneType = expenseTypeRepository.findById(expenseType.getId())
                .orElseThrow(() ->
                        new RuntimeException("Expense not found with id: " + expenseType.getId())
                );

        existingExpeneType.setName(expenseType.getName());
        expenseTypeRepository.save(existingExpeneType);
    }

    @Transactional
    public void deleteExpenseType(Long id) {
        expenseTypeRepository.findById(id)
                .ifPresentOrElse(
                        expenseTypeRepository::delete,
                        () -> {
                            throw new RuntimeException("Expense Type not found with id: " + id);
                        }
                );
    }
}
