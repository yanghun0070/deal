package com.num6pj.molamola.board.infra;

import com.num6pj.molamola.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findByCategoryId(Long categoryID);
}
