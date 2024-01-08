package com.zerobase.board.repository;

import com.zerobase.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    List<Board> findAllByOrderByCreatedTimeAsc();

    List<Board> findAllByOrderByCreatedTimeDesc();

    List<Board> findAllByOrderByViewsAsc();

    List<Board> findAllByOrderByViewsDesc();

    List<Board> findAllByOrderByTitleAsc();

    List<Board> findAllByOrderByTitleDesc();

    Board getOneById(int id);

    void deleteById(int id);

    List<Board> findAllByTitleContaining(String title);

    List<Board> findAllByTagContaining(String tag);

    List<Board> findAllByTextContaining(String text);
}