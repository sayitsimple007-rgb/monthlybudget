package com.example.monthlybudget.repository;
import com.example.monthlybudget.api.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
