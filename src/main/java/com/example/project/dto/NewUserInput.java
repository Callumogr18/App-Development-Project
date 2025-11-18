package com.example.project.dto;


import com.example.project.entity.MyUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewUserInput (
    @NotBlank String username,
    @NotBlank @Size(min=8) String password,
    @NotNull
    MyUser.Role role
){}


