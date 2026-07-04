package com.myFullstackZeyad.employee_management.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DepartmentCreate(
        @NotNull(message = "name is required")
        @Size(min = 2, max = 50, message = "min is 2 character and max is 50 characters")
        String name

) {
}
