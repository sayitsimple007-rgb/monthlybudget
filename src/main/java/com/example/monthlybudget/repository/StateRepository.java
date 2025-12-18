package com.example.monthlybudget.repository;

import com.example.monthlybudget.api.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
