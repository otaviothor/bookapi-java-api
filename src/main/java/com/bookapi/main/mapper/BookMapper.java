package com.bookapi.main.mapper;

import com.bookapi.main.dto.book.BookResponseDto;
import com.bookapi.main.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "createdById", source = "createdBy.id")
    BookResponseDto toResponseDto(Book book);
}
