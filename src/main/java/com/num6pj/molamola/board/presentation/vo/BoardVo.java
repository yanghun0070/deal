package com.num6pj.molamola.board.presentation.vo;

import lombok.Data;

@Data
public class BoardVo {
    final private Long catetoryId;
    final private Long userId;
    final private String title;
    final private String content;
}
