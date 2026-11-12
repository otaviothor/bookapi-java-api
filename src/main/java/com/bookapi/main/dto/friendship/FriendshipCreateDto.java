package com.bookapi.main.dto.friendship;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FriendshipCreateDto {

    @NotNull
    private Long addresseeId;
}
