package com.bookapi.main.repository;

import com.bookapi.main.entity.UserBook;
import com.bookapi.main.enums.ReadingStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserBookRepository extends JpaRepository<UserBook, Long> {

    Optional<UserBook> findByUser_IdAndBook_Id(Long userId, Long bookId);

    Page<UserBook> findByUser_Id(Long userId, Pageable pageable);

    Page<UserBook> findByUser_IdAndStatus(Long userId, ReadingStatus status, Pageable pageable);
}
