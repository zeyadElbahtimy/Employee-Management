package com.myFullstackZeyad.employee_management.controllers;

import com.myFullstackZeyad.employee_management.dtos.SignupRequest;
import com.myFullstackZeyad.employee_management.services.AuthService;
import com.myFullstackZeyad.employee_management.shared.GlobalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<GlobalResponse<String>> signup(
            @RequestBody SignupRequest signupRequest
    ) {
        authService.signup(signupRequest);
        System.out.println(signupRequest.employeeId());
        return new ResponseEntity<>(new GlobalResponse<>("Signed Up"), HttpStatus.CREATED);
    }
}
