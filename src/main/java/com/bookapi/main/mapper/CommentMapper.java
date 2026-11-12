package com.bookapi.main.mapper;

import com.bookapi.main.dto.comment.CommentResponseDto;
import com.bookapi.main.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "userBookId", source = "userBook.id")
    @Mapping(target = "authorId", source = "author.id")
    CommentResponseDto toResponseDto(Comment comment);
}
