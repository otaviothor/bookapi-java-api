package com.bookapi.main.dto.user;

import com.bookapi.main.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private UserRole role;
    private Instant createdAt;
    private Instant updatedAt;
}
