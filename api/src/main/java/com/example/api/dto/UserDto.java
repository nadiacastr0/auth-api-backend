package com.example.api.dto;

import com.example.api.enums.ProfileEnum;

import java.util.List;

public record UserDto(
        Long id,
        String name,
        String email,
        String cpf,
        List<ProfileEnum> profiles
) { }
