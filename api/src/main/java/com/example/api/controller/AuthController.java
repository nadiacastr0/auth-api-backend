package com.example.api.controller;

import com.example.api.dto.ChangePasswordDto;
import com.example.api.dto.LoginUserDto;
import com.example.api.dto.RecoveryJwtTokenDto;
import com.example.api.dto.RegisterDto;
import com.example.api.mapper.UserMapper;
import com.example.api.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;
    private final UserMapper mapper;

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDto> authenticateUser(@RequestBody LoginUserDto loginUserDto) {
        RecoveryJwtTokenDto token = new RecoveryJwtTokenDto(service.authenticateUser(loginUserDto.email(), loginUserDto.password()));
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterDto registerDto) {
        service.register(mapper.mapToDomain(registerDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(@RequestBody ChangePasswordDto dto) {
        service.changePassword(dto.email(), dto.currentPassword(), dto.newPassword());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}