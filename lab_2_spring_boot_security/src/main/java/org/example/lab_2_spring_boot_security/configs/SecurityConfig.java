package org.example.lab_2_spring_boot_security.configs;

import lombok.RequiredArgsConstructor;
import org.example.lab_2_spring_boot_security.federated.FederatedIdentityAuthenticationSuccessHandler;
import org.example.lab_2_spring_boot_security.federated.GithubGoogleUserHandler;
import org.example.lab_2_spring_boot_security.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http, UserRepository userRepository)
            throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .oauth2Login(oauth2 -> oauth2
                                .successHandler(authenticationSuccessHandler(userRepository))

                );
        return http.build();
    }

    private AuthenticationSuccessHandler authenticationSuccessHandler(UserRepository userRepository) {
        FederatedIdentityAuthenticationSuccessHandler successHandler = new FederatedIdentityAuthenticationSuccessHandler();
        successHandler.setOAuth2UserHandler(new GithubGoogleUserHandler(userRepository));
        return successHandler;
    }
}
