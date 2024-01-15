package com.zerobase.board.repository;

import com.zerobase.board.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    void deleteById(int id);
}
