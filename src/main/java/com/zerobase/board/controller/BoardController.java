package com.zerobase.board.controller;

import com.zerobase.board.domain.Board;
import com.zerobase.board.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/create/board")
    void createBoard(HttpServletRequest request) {
        boardService.createBoard(request.getParameter("title"), request.getParameter("tag"), request.getParameter("text"));
    }
//조회
    @GetMapping("/read/boardbycreatedtimeasc")
    List<Board> readBoardByCreatedTimeAsc(){ return boardService.readBoardByCreatedTimeAsc(); }
    @GetMapping("/read/boardbycreatedtimedesc")
    List<Board> readBoardByCreatedTimeDesc(){
        return boardService.readBoardByCreatedTimeDesc();
    }
    @GetMapping("/read/boardbyviewsasc")
    List<Board> readBoardByViewsAsc(){
        return boardService.readBoardByViewsAsc();
    }
    @GetMapping("/read/boardbyviewsdesc")
    List<Board> readBoardByViewsDesc(){
        return boardService.readBoardByViewsDesc();
    }
    @GetMapping("/read/boardbytitleasc")
    List<Board> readBoardByTitlesAsc(){
        return boardService.readBoardByTitleAsc();
    }
    @GetMapping("/read/boardbytitledesc")
    List<Board> readBoardByTitleDesc(){
        return boardService.readBoardByTitleDesc();
    }

//검색
    @GetMapping("/find/boardbytitle")
    List<Board> findByTitle(@RequestParam String title){
        return boardService.findByTitle(title);
    }
    @GetMapping("/find/boardbytag")
    List<Board> findByTag(@RequestParam String tag){
        return boardService.findByTag(tag);
    }
    @GetMapping("/find/boardbytext")
    List<Board> findByText(@RequestParam String text){
        return boardService.findByText(text);
    }

//수정
    @PutMapping("/modify/board")
    void modifyBoard(HttpServletRequest request){
        boardService.modifyBoard(Integer.parseInt(request.getParameter("id")), request.getParameter("title") , request.getParameter("tag"), request.getParameter("text"));
    }
//삭제
    @DeleteMapping("/delete/board")
    void deleteBoard(@RequestParam int id){
        boardService.deleteBoard(id);
    }
}

