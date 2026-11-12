package com.bookapi.main.dto.userbook;

import com.bookapi.main.enums.ReadingStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class UserBookResponseDto {

    private Long id;
    private Long userId;
    private Long bookId;
    private ReadingStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}
