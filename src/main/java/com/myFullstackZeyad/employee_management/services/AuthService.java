package com.myFullstackZeyad.employee_management.services;

import com.myFullstackZeyad.employee_management.dtos.SignupRequest;
import com.myFullstackZeyad.employee_management.entities.Employee;
import com.myFullstackZeyad.employee_management.entities.UserAccount;
import com.myFullstackZeyad.employee_management.reposotories.EmployeeRepo;
import com.myFullstackZeyad.employee_management.reposotories.UserAccountRepo;
import com.myFullstackZeyad.employee_management.shared.CustomResponceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserAccountRepo userAccountRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signup(SignupRequest signupRequest) {
        Employee employee = employeeRepo.findById(signupRequest.employeeId())
                .orElseThrow(() -> CustomResponceException.ResourceNotFound(
                        "Employee with id " + signupRequest.employeeId() + "not found"
                ));
        UserAccount account = new UserAccount();
        account.setUsername(signupRequest.username());
        account.setPassword(passwordEncoder.encode(signupRequest.password()));
        account.setEmployee(employee);
        userAccountRepo.save(account);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> account = userAccountRepo.findOneByUsername(username);

        if (account.isEmpty()) {
            throw CustomResponceException.BadCredentials();
        }

        UserAccount user = account.get();

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
