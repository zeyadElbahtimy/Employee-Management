package com.myFullstackZeyad.employee_management.services;

import com.myFullstackZeyad.employee_management.abstracts.EmployeeService;
import com.myFullstackZeyad.employee_management.dtos.EmployeeCreate;
import com.myFullstackZeyad.employee_management.dtos.EmployeeUpdate;
import com.myFullstackZeyad.employee_management.entities.Employee;
import com.myFullstackZeyad.employee_management.shared.CustomResponceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImp implements EmployeeService {
    ArrayList<Employee> employees = new ArrayList<>();


    public Employee findOne(UUID employeeId) {

        Employee employee = employees.stream()
                .filter(emp -> emp.getId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> CustomResponceException.ResourceNotFound("Employee  with id " + employeeId + " not found"));

        System.out.println("find one employee service");
        return employee;


    }


    public ArrayList<Employee> findAll() {
        return employees;
    }


    public void deleteOne(UUID employeeId) {
        Optional<Employee> employee = employees.stream().filter(emp -> emp.getId().equals(employeeId)).findFirst();
        employee.ifPresent(value -> employees.remove(value));

    }

    public Employee updateOne(UUID employeeId, EmployeeUpdate employee) {
        Employee existingEmployee = employees.stream().filter(emp -> emp.getId().equals(employeeId)).findFirst().orElseThrow(() -> CustomResponceException.ResourceNotFound("Employee  with id " + employeeId + " not found"));


        existingEmployee.setFirstName(employee.firstName());
        existingEmployee.setLastName(employee.lastName());
        existingEmployee.setPhoneNumber(employee.phoneNumber());

        existingEmployee.setPosition(employee.position());
        existingEmployee.setDepartmentId(existingEmployee.getDepartmentId());
        return existingEmployee;
    }

    @Override
    public Employee createOne(EmployeeCreate employeeCreate) {
        Employee employee = new Employee();

        employee.setId(UUID.randomUUID());
        employee.setDepartmentId(UUID.randomUUID());
        employee.setFirstName(employeeCreate.firstName());
        employee.setLastName(employeeCreate.lastName());
        employee.setPosition(employeeCreate.position());
        employee.setHireDate(employeeCreate.hireDate());
        employee.setPhoneNumber(employeeCreate.phoneNumber());
        employee.setEmail(employeeCreate.email());

        employees.add(employee);
        return employee;
    }

}
