package org.example.spring_boot_security_lab_1.requests;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {}
