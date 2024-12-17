package org.example.spring_boot_security_lab_1;

import lombok.RequiredArgsConstructor;
import org.example.spring_boot_security_lab_1.user.Role;
import org.example.spring_boot_security_lab_1.user.User;
import org.example.spring_boot_security_lab_1.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Lab1SpringBootSecurityApplication implements CommandLineRunner {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Lab1SpringBootSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(userRepository.count() == 0) {
			List<User> users = Arrays.asList(
					new User("user1", "user1", "user1@example.com", passwordEncoder.encode("password"), Role.ADMIN),
					new User("user2", "user2", "user2@example.com", passwordEncoder.encode("password"), Role.USER)
			);
			userRepository.saveAll(users);
		}
	}
}
