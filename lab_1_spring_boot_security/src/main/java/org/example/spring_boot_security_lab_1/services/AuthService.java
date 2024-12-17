package org.example.spring_boot_security_lab_1.services;


import org.example.spring_boot_security_lab_1.requests.AuthRequest;
import org.example.spring_boot_security_lab_1.requests.RegisterRequest;
import org.example.spring_boot_security_lab_1.responses.AuthenticationResponse;

public interface AuthService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthRequest request);
}
