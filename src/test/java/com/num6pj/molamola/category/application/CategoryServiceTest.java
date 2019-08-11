package com.num6pj.molamola.category.application;

import com.num6pj.molamola.category.domain.Category;
import com.num6pj.molamola.category.infra.CategoryRepository;
import com.num6pj.molamola.category.presentation.vo.CategoryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void createCategory(){
        Category category = new Category("LOL","morikim");
        categoryService.createCategory(category, "morikim");
    }

}
