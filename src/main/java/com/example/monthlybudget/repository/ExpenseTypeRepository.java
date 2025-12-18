package com.example.monthlybudget.repository;
import com.example.monthlybudget.api.model.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Long> {
}