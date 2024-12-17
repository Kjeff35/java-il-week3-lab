package org.example.spring_boot_security_lab_1.requests;

public record AuthRequest(
        String email,
        String password
) {}
