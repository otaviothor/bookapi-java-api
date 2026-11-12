package com.bookapi.main.mapper;

import com.bookapi.main.dto.friendship.FriendshipResponseDto;
import com.bookapi.main.entity.Friendship;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FriendshipMapper {

    @Mapping(target = "requesterId", source = "requester.id")
    @Mapping(target = "addresseeId", source = "addressee.id")
    FriendshipResponseDto toResponseDto(Friendship friendship);
}
