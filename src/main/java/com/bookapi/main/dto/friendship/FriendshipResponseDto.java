package com.bookapi.main.dto.friendship;

import com.bookapi.main.enums.FriendshipStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class FriendshipResponseDto {

    private Long id;
    private Long requesterId;
    private Long addresseeId;
    private FriendshipStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}
