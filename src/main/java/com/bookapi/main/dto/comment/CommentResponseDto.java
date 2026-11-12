package com.bookapi.main.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class CommentResponseDto {

    private Long id;
    private Long userBookId;
    private Long authorId;
    private String content;
    private Instant createdAt;
    private Instant updatedAt;
}
