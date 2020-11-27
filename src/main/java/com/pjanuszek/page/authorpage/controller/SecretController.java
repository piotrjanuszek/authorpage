package com.pjanuszek.page.authorpage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("backend/secret")
public class SecretController {

    private final String SECRET_MESSAGE = "42";

    @GetMapping("/get")
    @Async
    public ResponseEntity<String> getSecret() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = String.valueOf(securityContext.getAuthentication().isAuthenticated());
        return new ResponseEntity<String>("Hello " + username, HttpStatus.OK);
    }
}
