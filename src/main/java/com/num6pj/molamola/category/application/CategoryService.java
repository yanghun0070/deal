package com.num6pj.molamola.category.application;

import com.num6pj.molamola.category.domain.Category;
import com.num6pj.molamola.category.infra.CategoryRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(Category category, String userName) {
        categoryRepository.save(new Category(category.getName(), userName));
    }

    public void deleteCategory(){

    }

    public void updateCategory(){


    }

}
