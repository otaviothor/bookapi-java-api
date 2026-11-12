package com.bookapi.main.mapper;

import com.bookapi.main.dto.userbook.UserBookResponseDto;
import com.bookapi.main.entity.UserBook;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserBookMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "bookId", source = "book.id")
    UserBookResponseDto toResponseDto(UserBook userBook);
}
