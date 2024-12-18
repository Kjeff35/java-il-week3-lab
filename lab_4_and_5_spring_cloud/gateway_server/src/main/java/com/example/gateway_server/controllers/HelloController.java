package com.example.gateway_server.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String hello(@AuthenticationPrincipal OidcUser oidcUser) {
        System.out.println(oidcUser.getSubject());
        System.out.println(oidcUser.getEmail());
        System.out.println(oidcUser.getFamilyName());
        return "Hello World";
    }
}
