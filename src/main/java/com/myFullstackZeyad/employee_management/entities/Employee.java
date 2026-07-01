package com.myFullstackZeyad.employee_management.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Employee {

    private UUID id;


    private String firstName;


    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDate hireDate;

    private String position;

    private UUID departmentId;
}