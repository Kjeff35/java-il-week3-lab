package org.example.spring_boot_security_lab_1.services;

import lombok.RequiredArgsConstructor;
import org.example.spring_boot_security_lab_1.exceptions.NotFoundException;
import org.example.spring_boot_security_lab_1.jwt_authentication.JwtService;
import org.example.spring_boot_security_lab_1.requests.AuthRequest;
import org.example.spring_boot_security_lab_1.requests.RegisterRequest;
import org.example.spring_boot_security_lab_1.responses.AuthenticationResponse;
import org.example.spring_boot_security_lab_1.user.Role;
import org.example.spring_boot_security_lab_1.user.User;
import org.example.spring_boot_security_lab_1.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthRequest request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new NotFoundException("user not found"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
