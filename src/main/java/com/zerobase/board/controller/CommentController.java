package com.zerobase.board.controller;

import com.zerobase.board.service.CommentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("comment/write")
    void writeComment(@RequestBody String comment){
        commentService.writeComment(comment);
    }

    @DeleteMapping("comment/delete")
    void deleteComment(@RequestBody int id){
        commentService.deleteComment(id);
    }

}
