package com.num6pj.molamola.board.domain;

import com.num6pj.molamola.category.domain.Category;
import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;


@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardId;
    final private Long userId;
    final private String title;
    final private String content;

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


}
