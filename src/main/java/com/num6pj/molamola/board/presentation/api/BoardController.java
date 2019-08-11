package com.num6pj.molamola.board.presentation.api;

import com.num6pj.molamola.board.application.BoardService;
import com.num6pj.molamola.board.domain.Board;
import com.num6pj.molamola.board.presentation.vo.BoardVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/category/board")
@RestController
public class BoardController {


    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/create")
    public void makeBoard(@RequestBody BoardVo board){
        boardService.savePost(board);
    }
    @GetMapping("{id}")
    public void getBoard(@PathVariable Long boardId){
        boardService.getPost(boardId);
    }

    @DeleteMapping("delete")
    public void deleteBoard( @RequestParam Long boardId){
        boardService.deletePost(boardId);
    }

 }
