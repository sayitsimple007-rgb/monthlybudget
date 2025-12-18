package com.example.monthlybudget.repository;
import com.example.monthlybudget.api.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
