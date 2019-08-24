package com.num6pj.molamola.category.application;

import com.num6pj.molamola.board.domain.Board;
import com.num6pj.molamola.board.infra.BoardRepository;
import com.num6pj.molamola.category.domain.Category;
import com.num6pj.molamola.category.infra.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {


    private CategoryRepository categoryRepository;
    private BoardRepository boardRepository;

    public CategoryService(CategoryRepository categoryRepository, BoardRepository boardRepository) {
        this.categoryRepository = categoryRepository;
        this.boardRepository = boardRepository;
    }

    public List<Category> getCategoryList(){
        List<Category> categories = categoryRepository.findAll();
        categories.stream().forEach(e->System.out.println(e.toString()));
        return categoryRepository.findAll();
    }

    public void createCategory(Category category, String userName) {
            categoryRepository.save(new Category(category.getName(), userName));
    }
    /*
    TODO. cateory의 id 사용해서 board list 가지고 오기
    */
    //category에 해당하는 board를 불러오기
    public List<Board> getCategoryBoards(Long categoryId){
        return categoryRepository.findById(categoryId).orElseGet(null).getBoardsByCategoryId();
    }

    public void deleteCategory(){

    }

    public void updateCategory(){

    }

}
