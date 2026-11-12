package com.bookapi.main.repository;

import com.bookapi.main.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findByUserBook_IdOrderByCreatedAtAsc(Long userBookId, Pageable pageable);
}
