package com.myFullstackZeyad.employee_management.controllers;

import com.myFullstackZeyad.employee_management.abstracts.EmployeeService;
import com.myFullstackZeyad.employee_management.dtos.EmployeeCreate;
import com.myFullstackZeyad.employee_management.entities.Employee;
import com.myFullstackZeyad.employee_management.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    ArrayList<Employee> employees = new ArrayList<>(
//            List.of(
//                    new Employee(
//                    UUID.randomUUID(),           // id
//                    "Zeyad",                     // firstName
//                    "Elbahtimy",                 // LastName
//                    "zeyad@example.com",         // email
//                    "0123456789",                // phoneNumber
//                    LocalDate.of(2022, 6, 15),  // hireDate
//                    "Java Developer",            // position
//                    UUID.randomUUID()    ),
//new Employee(
//            UUID.randomUUID(),           // id
//            "Zeyad",                     // firstName
//                    "Elbahtimy",                 // LastName
//                    "zeyad@example.com",         // email
//                    "0123446789",                // phoneNumber
//                    LocalDate.of(2022, 6, 15),  // hireDate
//                    "Software Developer",            // position
//                    UUID.randomUUID()    )
//
//                    )        // department

    );
    @Autowired
    private EmployeeService employeeService;

//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//
//
//    }

    @GetMapping


    public ResponseEntity<GlobalResponse<ArrayList<Employee>>> findAll() {
        ArrayList<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(new GlobalResponse<>(employees), HttpStatus.OK);
    }


//    public ResponseEntity<ArrayList<Employee>> findAll() {
//
//        return new ResponseEntity<ArrayList<Employee>>(employees, HttpStatus.OK);
//    }

//    @GetMapping("/{employeeId}")
//    public UUID findOne(@PathVariable UUID employeeId){
//       return employeeId;
//    }
//
//    @GetMapping("/hello2")
//    public String helloWorld2(){
//        return "hello , World2";
//    }


//    @GetMapping("/{employeeId}")
//    public Optional<Employee> findOne(@PathVariable UUID employeeId) {
//        Optional<Employee> employee = employees.stream().filter(emp -> emp.getId().equals(employeeId)).findFirst();
//        return employee;
//    }

//    @GetMapping("/{employeeId}")
//    public ResponseEntity<Employee> findOne(@PathVariable UUID employeeId) {
//        Optional<Employee> employee = employees.stream().filter(emp -> emp.getId().equals(employeeId)).findFirst();
//
//        if (employee.isEmpty()) {
//            // return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
//            throw CustomResponceException.ResourceNotFound("Employee with id " + employeeId + " not found");
//
//
//        }
//        return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
//
//
//    }


    @GetMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>> findOne(@PathVariable UUID employeeId) {
        Employee employee = employeeService.findOne(employeeId);


        return new ResponseEntity<GlobalResponse<Employee>>(new GlobalResponse<>(employee), HttpStatus.OK);


    }
//    public Employee createOne(@RequestBody Employee employee) {
//        employee.setId(UUID.randomUUID());
//        employee
//        .setDepartmentId(UUID.randomUUID());
//        employees.add(employee);
//        return employee;
//    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Employee>> createOne(@RequestBody @Valid EmployeeCreate employee) {
        Employee newEmployee = employeeService.createOne(employee);

        return new ResponseEntity<>(new GlobalResponse<>(newEmployee), HttpStatus.OK);
    }


//    public Employee updateOne(
//            @PathVariable UUID employeeId,
//            @RequestBody Employee employee) {
//        Optional<Employee> existingEmployee = employees.stream().filter(emp -> emp.getId().equals(employeeId)).findFirst();
//        if (existingEmployee.isPresent()) {
//            existingEmployee.get().setFirstName(employee.getFirstName());
//            existingEmployee.get().setLastName(employee.getLastName());
//            existingEmployee.get().setEmail(employee.getEmail());
//            existingEmployee.get().setPosition(employee.getPosition());
//            existingEmployee.get().setHireDate(employee.getHireDate());
//            existingEmployee.get().setDepartmentId(employee.getDepartmentId());
//        }
//        return employee;
//    }

    @PutMapping("{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>> updateOne(
            @PathVariable UUID employeeId,
            @RequestBody @Valid EmployeeUpdate employee) {
        Employee updatedEmployee = employeeService.updateOne(employeeId, employee);

        return new ResponseEntity<>(new GlobalResponse<>(updatedEmployee), HttpStatus.OK);
    }

//    @DeleteMapping("{employeeId}")
//    public void deleteOne(@PathVariable UUID employeeId) {
//        Optional<Employee> employee = employees.stream().filter(emp -> emp.getId().equals(employeeId)).findFirst();
//        if (employee.isPresent()) {
//            employees.remove(employee.get());
//
//        }

//    }

    @DeleteMapping("{employeeId}")
    public ResponseEntity<Void> deleteOne(@PathVariable UUID employeeId) {
        employeeService.deleteOne(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


