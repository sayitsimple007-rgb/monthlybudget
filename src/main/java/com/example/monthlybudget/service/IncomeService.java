package com.example.monthlybudget.service;
import com.example.monthlybudget.api.model.Income;
import com.example.monthlybudget.repository.IncomeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IncomeService {
    private final IncomeRepository incomeRepository;
    @Autowired
    public IncomeService(IncomeRepository incomeRepository){
        this.incomeRepository = incomeRepository;
    }
    public Optional getIncome(Long id){
        Optional optional = Optional.empty();
        for (Income income: incomeRepository.findAll()){
            if(Objects.equals(id, income.getId())){
                optional = Optional.of(income);
                return optional;
            }
        }
        return optional;
    }

    public List<Income> getIncomes(){
        return incomeRepository.findAll();
    }

    @Transactional
    public void addIncome(Income income){
        System.out.println(income);
        incomeRepository.save(income);
    }

    @Transactional
    public void updateIncome(Income income) {
        Income existingIncome = incomeRepository.findById(income.getId())
                .orElseThrow(() ->
                        new RuntimeException("Expense not found with id: " + income.getId())
                );

        existingIncome.setName(income.getName());
        incomeRepository.save(existingIncome);
    }

    @Transactional
    public void deleteIncome(Long id) {
        incomeRepository.findById(id)
                .ifPresentOrElse(
                        incomeRepository::delete,
                        () -> {
                            throw new RuntimeException("Income not found with id: " + id);
                        }
                );
    }
}
