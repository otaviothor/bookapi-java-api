package com.bookapi.main.dto.userbook;

import com.bookapi.main.enums.ReadingStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserBookCreateDto {

    @NotNull
    private Long bookId;

    private ReadingStatus status = ReadingStatus.WANT_TO_READ;
}
