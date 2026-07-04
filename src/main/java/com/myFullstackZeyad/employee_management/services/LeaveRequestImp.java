package com.myFullstackZeyad.employee_management.services;

import com.myFullstackZeyad.employee_management.abstracts.LeaveRequestService;
import com.myFullstackZeyad.employee_management.dtos.LeaveRequestCreate;
import com.myFullstackZeyad.employee_management.entities.Employee;
import com.myFullstackZeyad.employee_management.entities.LeaveRequest;
import com.myFullstackZeyad.employee_management.reposotories.EmployeeRepo;
import com.myFullstackZeyad.employee_management.reposotories.LeaveRequestRepo;
import com.myFullstackZeyad.employee_management.shared.CustomResponceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service


public class LeaveRequestImp implements LeaveRequestService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private LeaveRequestRepo leaveRequestRepo;

    public LeaveRequest createOne(LeaveRequestCreate leaveRequestCreate,
                                  UUID employeeId) {

        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponceException.ResourceNotFound(
                        "Employee with id" + employeeId + "not found"
                ));

        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setStatus("PENDING");
        leaveRequest.setReason(leaveRequestCreate.reason());
        leaveRequest.setStartDate(leaveRequestCreate.startDate());
        leaveRequest.setEndDate(leaveRequestCreate.endDate());
        leaveRequest.setEmployee(employee);

        leaveRequestRepo.save(leaveRequest);
        return leaveRequest;
    }

    @Override
    public List<LeaveRequest> findAllByEmployeeId(UUID employeeId) {

        return leaveRequestRepo.findAllByEmployeeId(employeeId);

    }


}
