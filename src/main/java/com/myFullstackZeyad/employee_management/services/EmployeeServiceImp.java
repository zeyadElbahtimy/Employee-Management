package com.myFullstackZeyad.employee_management.services;

import com.myFullstackZeyad.employee_management.abstracts.EmployeeService;
import com.myFullstackZeyad.employee_management.dtos.EmployeeCreate;
import com.myFullstackZeyad.employee_management.dtos.EmployeeUpdate;
import com.myFullstackZeyad.employee_management.entities.Department;
import com.myFullstackZeyad.employee_management.entities.Employee;
import com.myFullstackZeyad.employee_management.reposotories.DepartmentRepo;
import com.myFullstackZeyad.employee_management.reposotories.EmployeeRepo;
import com.myFullstackZeyad.employee_management.shared.CustomResponceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;


    public Employee findOne(UUID employeeId) {

        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponceException.ResourceNotFound("Employee  with id " + employeeId + " not found"));

        System.out.println("find one employee service");
        return employee;


    }


    public List<Employee> findAll() {

        return employeeRepo.findAll();
    }


    public void deleteOne(UUID employeeId) {
        Optional<Employee> employee = employeeRepo.findById(employeeId);

        employee.ifPresent(value -> employeeRepo.deleteById(value.getId()));

    }

    public Employee updateOne(UUID employeeId, EmployeeUpdate employee) {
        Employee existingEmployee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponceException.ResourceNotFound("Employee  with id " + employeeId + " not found"));


        existingEmployee.setFirstName(employee.firstName());
        existingEmployee.setLastName(employee.lastName());
        existingEmployee.setPhoneNumber(employee.phoneNumber());

        existingEmployee.setPosition(employee.position());
        employeeRepo.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public Employee createOne(EmployeeCreate employeeCreate) {
        Employee employee = new Employee();
        Department department = departmentRepo.findById(employeeCreate.departmentId())
                .orElseThrow(() -> CustomResponceException.ResourceNotFound(
                        "Department With Id" + employeeCreate.departmentId() + " not found"
                ));
        employee.setFirstName(employeeCreate.firstName());
        employee.setLastName(employeeCreate.lastName());
        employee.setPosition(employeeCreate.position());
        employee.setHireDate(employeeCreate.hireDate());
        employee.setPhoneNumber(employeeCreate.phoneNumber());
        employee.setEmail(employeeCreate.email());
        employee.setDepartment(department);
        employeeRepo.save(employee);
        return employee;
    }

}
