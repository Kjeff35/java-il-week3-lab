package org.example.spring_boot_security_lab_1.controllers;

import lombok.RequiredArgsConstructor;
import org.example.spring_boot_security_lab_1.requests.AuthRequest;
import org.example.spring_boot_security_lab_1.requests.RegisterRequest;
import org.example.spring_boot_security_lab_1.responses.AuthenticationResponse;
import org.example.spring_boot_security_lab_1.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {

    @GetMapping
    public String hello(){
        return "Hello World";
    }

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthRequest request
    ){
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
