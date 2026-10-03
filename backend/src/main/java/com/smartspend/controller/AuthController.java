package com.smartspend.controller;

import com.smartspend.dto.AuthResponse;
import com.smartspend.dto.RegisterRequest;
import com.smartspend.entity.User;
import com.smartspend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
        @Valid @RequestBody RegisterRequest request) {

    User user = authService.register(request);

    AuthResponse response = new AuthResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.isEmailVerified()
    );

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
}
}