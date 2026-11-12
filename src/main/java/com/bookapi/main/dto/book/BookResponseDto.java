package com.bookapi.main.dto.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class BookResponseDto {

    private Long id;
    private String title;
    private String author;
    private String description;
    private String coverImageUrl;
    private Long createdById;
    private Instant createdAt;
    private Instant updatedAt;
}
