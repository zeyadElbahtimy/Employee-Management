package com.myFullstackZeyad.employee_management.abstracts;

import com.myFullstackZeyad.employee_management.dtos.EmployeeCreate;
import com.myFullstackZeyad.employee_management.dtos.EmployeeUpdate;
import com.myFullstackZeyad.employee_management.entities.Employee;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee findOne(UUID employeeID);

    List<Employee> findAll();

    void deleteOne(UUID employeeId);

    Employee updateOne(UUID employeeId, EmployeeUpdate employee);

    Employee createOne(@Valid EmployeeCreate employee);
}
