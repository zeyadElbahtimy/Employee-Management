package com.myFullstackZeyad.employee_management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "leave_request")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequest {
    @Id
    @UuidGenerator
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;


    @Column(name = "reason", columnDefinition = "TEXT")
    private String reason;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

//    private UUID getEmployee() {
//        return employee.getId();
//    }

}
