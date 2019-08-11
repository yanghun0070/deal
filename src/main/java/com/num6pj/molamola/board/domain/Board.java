package com.num6pj.molamola.board.domain;

import com.num6pj.molamola.category.domain.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;



@Entity
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardId;
    private Long userId;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;

    public Board( Long userId, String title, String content, Category category) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    @ManyToOne
    public Category getCategory(){
        return category;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
