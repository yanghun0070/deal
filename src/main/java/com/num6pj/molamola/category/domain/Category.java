package com.num6pj.molamola.category.domain;



import com.num6pj.molamola.board.domain.Board;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="category")
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     private String name; //카테고리명
     private String userName; //유저명
     private LocalDateTime createDate; //생성 날짜

    @OneToMany(mappedBy = "category")
    private List<Board> boards = new ArrayList<>();


    public Category(String name, String userName) {
        this.name = name;
        this.userName = userName;
        this.createDate = LocalDateTime.now();
    }

    public List<Board> getBoardsByCategoryId(){
        return boards;
    }

}
