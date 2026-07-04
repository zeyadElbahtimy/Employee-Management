package com.myFullstackZeyad.employee_management.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record LeaveRequestCreate(

        @NotNull(message = "reason name is required")
        @Size(min = 2, max = 100, message = " reason must be between 2 and 100 characters")
        String reason,


        @NotNull(message = "start date is required")
        @FutureOrPresent(message = "start date cannot be in the future")
        LocalDate startDate,

        @NotNull(message = "end date is required")
        @FutureOrPresent(message = "end date cannot be in the future")
        LocalDate endDate

) {
}
