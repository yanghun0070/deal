package com.num6pj.molamola.category.domain;



import com.num6pj.molamola.board.domain.Board;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="category")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
}
