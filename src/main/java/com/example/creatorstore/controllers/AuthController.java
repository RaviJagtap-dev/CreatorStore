package com.example.creatorstore.controllers;

import com.example.creatorstore.dto.LoginRequest;
import com.example.creatorstore.dto.RegisterRequest;
import com.example.creatorstore.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        System.out.println("LOGIN HIT");
        System.out.println(request.getEmail());

        return authService.login(request);
    }
    @GetMapping("/test")
    public String test() {
        return "Working";
    }
}