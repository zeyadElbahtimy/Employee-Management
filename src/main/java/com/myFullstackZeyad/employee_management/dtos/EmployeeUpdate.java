package com.myFullstackZeyad.employee_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record EmployeeUpdate(@NotNull(message = "First name is required")
                             @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
                             String firstName,

                             @NotNull(message = "Last name is required")
                             @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
                             String lastName,


                             String phoneNumber,

                             @NotNull(message = "Hire date is required")
                             @PastOrPresent(message = "Hire date cannot be in the future")
                             LocalDate hireDate,

                             @NotBlank(message = "Position is required")
                             String position) {
}
