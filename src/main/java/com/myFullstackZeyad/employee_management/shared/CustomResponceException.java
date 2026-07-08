package com.myFullstackZeyad.employee_management.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomResponceException extends RuntimeException {
    private int code;
    private String message;


    public static CustomResponceException ResourceNotFound(String message) {
        return new CustomResponceException(404, message);
    }

    public static CustomResponceException BadCredentials() {
        return new CustomResponceException(401, "bad credentials");
    }
}
