package com.zerobase.board.service;

import com.zerobase.board.domain.Board;
import com.zerobase.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
//작성
    public void createBoard(String title, String tag, String text){
        LocalDateTime now = LocalDateTime.now();
        now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Board nowBoard = new Board();

        nowBoard.setTitle(title);
        nowBoard.setText(text);
        nowBoard.setTag(tag);
        nowBoard.setCreatedTime(now);
        boardRepository.save(nowBoard);
    }

//조회
    public List<Board> readBoardByCreatedTimeAsc(){ return boardRepository.findAllByOrderByCreatedTimeAsc(); }
    public List<Board> readBoardByCreatedTimeDesc(){
        return boardRepository.findAllByOrderByCreatedTimeDesc();
    }
    public List<Board> readBoardByViewsAsc(){
        return boardRepository.findAllByOrderByViewsAsc();
    }
    public List<Board> readBoardByViewsDesc(){
        return boardRepository.findAllByOrderByViewsDesc();
    }
    public List<Board> readBoardByTitleAsc(){
        return boardRepository.findAllByOrderByTitleAsc();
    }
    public List<Board> readBoardByTitleDesc(){
        return boardRepository.findAllByOrderByTitleDesc();
    }

//검색
    public List<Board> findByTitle(String title){
        return boardRepository.findAllByTitleContaining(title);
    }
    public List<Board> findByTag(String tag){
        return boardRepository.findAllByTagContaining(tag);
    }
    public List<Board> findByText(String text){
        return boardRepository.findAllByTextContaining(text);
    }

//수정
    public void modifyBoard(int id, String title, String tag, String text){
        LocalDateTime now = LocalDateTime.now();
        now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Board nowBoard = boardRepository.getOneById(id);

        nowBoard.setTitle(title);
        nowBoard.setText(text);
        nowBoard.setTag(tag);
        nowBoard.setModifiedTime(now);
        boardRepository.save(nowBoard);
    }

//삭제
    public void deleteBoard(int id){
        boardRepository.deleteById(id);
    }

}