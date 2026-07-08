package com.myFullstackZeyad.employee_management.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record SignupRequest(

        @NotNull(message = "username is required")
        @Size(min = 2, max = 50, message = "min is 2 ch max is 50 ")
        String username,
        @NotNull(message = "username is required")
        @Size(min = 2, max = 50, message = "min is 2 ch max is 50 ")
        String password,
        @NotNull(message = "employeeId is required")
        UUID employeeId) {
}
