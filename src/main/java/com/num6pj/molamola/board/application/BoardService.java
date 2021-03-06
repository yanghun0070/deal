package com.num6pj.molamola.board.application;

import com.num6pj.molamola.board.domain.Board;
import com.num6pj.molamola.board.infra.BoardRepository;
import com.num6pj.molamola.board.presentation.vo.BoardVo;
import com.num6pj.molamola.category.domain.Category;
import com.num6pj.molamola.category.infra.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private BoardRepository boardRepository;
    private CategoryRepository categoryRepository;
    public BoardService(BoardRepository boardRepository,CategoryRepository categoryRepository) {
        this.boardRepository = boardRepository;
        this.categoryRepository = categoryRepository;
    }

    public void savePost(BoardVo newBoard){
        Category category = categoryRepository.findById(newBoard.getCatetoryId()).orElseGet(null);

        Board board = new Board(newBoard.getUserId(),newBoard.getTitle(),newBoard.getContent(),category);
        boardRepository.save(board);
    }

    public Board getPost(Long boardId){
       return boardRepository.findById(boardId).orElseGet(null);
    }

    public void deletePost(Long board){
        boardRepository.deleteById( board);
    }
}
