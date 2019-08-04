package com.num6pj.molamola.category.infra;

import com.num6pj.molamola.category.domain.Category;
import com.num6pj.molamola.category.presentation.vo.CategoryVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {


    CategoryRepository categoryRepository;

    /*
    TODO. repository 수정하기
     */
    @Test
    public void createCategory(){

        CategoryVO cvo= new CategoryVO("LOL",(int)new Date().getTime()/1000);
        Category category = new Category(cvo);

        categoryRepository.save(category);

        System.out.println(categoryRepository.findAll());

    }

}
