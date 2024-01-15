package com.zerobase.board.service;

import com.zerobase.board.domain.Comment;
import com.zerobase.board.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
//댓글 작성
    public void writeComment(String comment){
        LocalDateTime now = LocalDateTime.now();
        now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Comment nCommnet = new Comment();

        nCommnet.setComment(comment);
        nCommnet.setCreatedTime(now);
        commentRepository.save(nCommnet);
    }

//댓글 삭제
    public void deleteComment(int commentId){
        commentRepository.deleteById(commentId);
    }
}
