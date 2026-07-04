package com.myFullstackZeyad.employee_management.reposotories;

import com.myFullstackZeyad.employee_management.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, UUID> {

}
