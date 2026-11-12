package com.bookapi.main.repository;

import com.bookapi.main.entity.Friendship;
import com.bookapi.main.enums.FriendshipStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    @Query("""
            select case when count(friendship) > 0 then true else false end
            from Friendship friendship
            where (friendship.requester.id = :firstUserId and friendship.addressee.id = :secondUserId)
               or (friendship.requester.id = :secondUserId and friendship.addressee.id = :firstUserId)
            """)
    boolean existsBetweenUsers(
            @Param("firstUserId") Long firstUserId,
            @Param("secondUserId") Long secondUserId
    );

    List<Friendship> findByAddressee_IdAndStatus(Long addresseeId, FriendshipStatus status);

    List<Friendship> findByRequester_IdAndStatus(Long requesterId, FriendshipStatus status);

    List<Friendship> findByRequester_IdOrAddressee_Id(Long requesterId, Long addresseeId);
}
