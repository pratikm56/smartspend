package com.smartspend.service;

import com.smartspend.dto.IncomeRequest;
import com.smartspend.entity.Income;
import com.smartspend.entity.User;
import com.smartspend.repository.IncomeRepository;
import com.smartspend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;
    private final UserRepository userRepository;

    public IncomeService(
            IncomeRepository incomeRepository,
            UserRepository userRepository
    ) {
        this.incomeRepository = incomeRepository;
        this.userRepository = userRepository;
    }

    public Income createIncome(UUID userId, IncomeRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Income income = new Income();

        income.setUser(user);
        income.setAmount(request.getAmount());
        income.setCategory(request.getCategory());
        income.setDescription(request.getDescription());
        income.setDate(request.getDate());
        income.setNotes(request.getNotes());

        return incomeRepository.save(income);
    }

    public List<Income> getUserIncomes(UUID userId) {

        return incomeRepository.findByUserIdOrderByDateDesc(userId);
    }
}