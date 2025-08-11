package com.example.api.mapper;

import com.example.api.dto.RegisterDto;
import com.example.api.dto.UserDto;
import com.example.api.entities.User;

public interface UserMapper {

    User mapToDomain(RegisterDto dto);

    User mapToDomain(UserDto userDto);

    UserDto mapToDto(User user);

}
