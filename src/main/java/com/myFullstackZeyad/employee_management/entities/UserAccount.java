package com.myFullstackZeyad.employee_management.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "user_account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID id;

    @Column(name = "username", nullable = false, length = 100, unique = true)
    private String username;
    @Column(name = "password", nullable = false, length = 100)
    private String password;


    @Column(name = "role", nullable = false, length = 20)
    private String role = "USER";

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_Id", unique = true, nullable = false)
    //unique is what makes the table relation one to one
    private Employee employee;

}
