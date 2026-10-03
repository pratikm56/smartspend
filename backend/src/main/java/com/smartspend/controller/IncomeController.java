package com.smartspend.controller;

import com.smartspend.dto.IncomeRequest;
import com.smartspend.entity.Income;
import com.smartspend.service.IncomeService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Income> createIncome(
            @PathVariable UUID userId,
            @Valid @RequestBody IncomeRequest request) {

        Income income = incomeService.createIncome(userId, request);

        return ResponseEntity.ok(income);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Income>> getUserIncomes(
            @PathVariable UUID userId) {

        List<Income> incomes = incomeService.getUserIncomes(userId);

        return ResponseEntity.ok(incomes);
    }
}