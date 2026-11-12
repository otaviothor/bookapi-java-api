package com.bookapi.main.mapper;

import com.bookapi.main.dto.user.UserResponseDto;
import com.bookapi.main.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto toResponseDto(User user);
}
