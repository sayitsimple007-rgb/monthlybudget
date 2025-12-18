package com.example.monthlybudget.repository;
import com.example.monthlybudget.api.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
