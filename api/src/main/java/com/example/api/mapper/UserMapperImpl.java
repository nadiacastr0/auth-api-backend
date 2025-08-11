package com.example.api.mapper;

import com.example.api.dto.RegisterDto;
import com.example.api.dto.UserDto;
import com.example.api.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User mapToDomain(UserDto dto) {
        if (dto == null) {
            return null;
        }

        return User.builder()
                .name(dto.name())
                .email(dto.email())
                .cpf(dto.cpf())
                .profiles(dto.profiles())
                .build();
    }

    @Override
    public User mapToDomain(RegisterDto dto) {
        if (dto == null) {
            return null;
        }

        return User.builder()
                .name(dto.name())
                .email(dto.email())
                .password(dto.password())
                .cpf(dto.cpf())
                .profiles(dto.profiles())
                .build();
    }

    @Override
    public UserDto mapToDto(User user) {
        if (user == null) {
            return null;
        }

        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCpf(),
                user.getProfiles()
        );
    }

}
