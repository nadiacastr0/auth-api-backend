package com.example.api.dto;

public record ChangePasswordDto(String email, String currentPassword, String newPassword) {}