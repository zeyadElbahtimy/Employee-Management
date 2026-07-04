package com.myFullstackZeyad.employee_management.abstracts;

import com.myFullstackZeyad.employee_management.dtos.DepartmentCreate;
import com.myFullstackZeyad.employee_management.entities.Department;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {
    Department findOne(UUID departmentId);

    List<Department> findAll();

    Department createOne(DepartmentCreate departmentCreate);

    void deleteOne(UUID departmentId);


}
