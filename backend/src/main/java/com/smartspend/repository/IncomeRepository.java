package com.smartspend.repository;

import com.smartspend.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IncomeRepository extends JpaRepository<Income, UUID> {

    List<Income> findByUserIdOrderByDateDesc(UUID userId);

    List<Income> findByUserIdAndDateBetweenOrderByDateDesc(
            UUID userId,
            LocalDate startDate,
            LocalDate endDate
    );

    List<Income> findByUserIdAndCategoryOrderByDateDesc(
            UUID userId,
            String category
    );
}