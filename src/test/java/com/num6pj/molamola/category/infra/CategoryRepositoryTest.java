package com.num6pj.molamola.category.infra;

import com.num6pj.molamola.category.domain.Category;
import com.num6pj.molamola.category.presentation.vo.CategoryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void createCategory(){
        categoryRepository.save(new Category("LOL", "morikim"));
    }

}
