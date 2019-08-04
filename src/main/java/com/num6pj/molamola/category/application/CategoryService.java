package com.num6pj.molamola.category.application;

import com.num6pj.molamola.category.domain.Category;
import com.num6pj.molamola.category.infra.CategoryRepository;
import com.num6pj.molamola.category.presentation.vo.CategoryVO;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {


    private CategoryRepository categoryReposiotory;

    public CategoryService( CategoryRepository categoryRepository) {
        this.categoryReposiotory = categoryRepository;
    }

    /*
    category 생성이 잘 되면 true, 잘 안되면 false 반환
     */
    public boolean createCategory( CategoryVO cateVO){
        Category category = new Category(cateVO);
        Optional<Category> cate =Optional.ofNullable(categoryReposiotory.save(category));
        if(cate.isPresent()){
//            System.out.println(cate.toString());
            return true;
        }
        return false;
    }

    public void deleteCategory(){

    }

    public void updateCategory(){


    }

}
