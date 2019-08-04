package com.num6pj.molamola.category.application;

import com.num6pj.molamola.category.domain.Category;
import com.num6pj.molamola.category.infra.CategoryRepository;
import com.num6pj.molamola.category.presentation.vo.CategoryVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void craeteCategory(){
        System.out.println(categoryService);
        CategoryVO  catevoryVO = new CategoryVO("LOL",(int)new Date().getTime()/1000);
        categoryService.createCategory(catevoryVO);
//        categoryRepository.save(category);
//        System.out.println(categoryRepository.findAll().isEmpty());
    }

}
