package com.smartspend.repository;

import com.smartspend.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

    List<Expense> findByUserIdOrderByDateDesc(UUID userId);

    List<Expense> findByUserIdAndDateBetweenOrderByDateDesc(
            UUID userId,
            LocalDate startDate,
            LocalDate endDate
    );

    List<Expense> findByUserIdAndCategoryOrderByDateDesc(
            UUID userId,
            String category
    );
}