package com.codewithmosh.store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6)
    @Size(max = 20)
    private String password;

}
