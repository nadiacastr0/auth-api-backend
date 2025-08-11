package com.example.api.dto;

import com.example.api.enums.ProfileEnum;

import java.util.List;

public record RegisterDto(
        String name,
        String email,
        String password,
        String cpf,
        List<ProfileEnum> profiles
) { }
