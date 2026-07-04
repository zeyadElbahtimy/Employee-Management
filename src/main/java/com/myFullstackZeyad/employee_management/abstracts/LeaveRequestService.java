package com.myFullstackZeyad.employee_management.abstracts;

import com.myFullstackZeyad.employee_management.dtos.LeaveRequestCreate;
import com.myFullstackZeyad.employee_management.entities.LeaveRequest;

import java.util.List;
import java.util.UUID;

public interface LeaveRequestService {

    LeaveRequest createOne(LeaveRequestCreate leaveRequestCreate, UUID employeeId);

    List<LeaveRequest> findAllByEmployeeId(UUID employeeId);


}
