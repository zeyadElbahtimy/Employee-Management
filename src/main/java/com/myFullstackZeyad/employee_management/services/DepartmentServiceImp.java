package com.myFullstackZeyad.employee_management.services;

import com.myFullstackZeyad.employee_management.abstracts.DepartmentService;
import com.myFullstackZeyad.employee_management.dtos.DepartmentCreate;
import com.myFullstackZeyad.employee_management.entities.Department;
import com.myFullstackZeyad.employee_management.reposotories.DepartmentRepo;
import com.myFullstackZeyad.employee_management.shared.CustomResponceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;


    @Override
    public Department findOne(UUID departmentId) {

        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> CustomResponceException.ResourceNotFound("Department  with id " + departmentId + " not found"));

        System.out.println("find one employee service");
        return department;
    }


    @Override
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }

    @Override
    public Department createOne(DepartmentCreate departmentCreate) {
        Department department = new Department();
        department.setName(departmentCreate.name());
        departmentRepo.save(department);
        return department;
    }

    @Override
    public void deleteOne(UUID departmentId) {
        departmentRepo.deleteById(departmentId);
    }
}
