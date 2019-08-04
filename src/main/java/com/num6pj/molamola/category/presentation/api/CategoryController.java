package com.num6pj.molamola.category.presentation.api;

import com.num6pj.molamola.category.application.CategoryService;
import com.num6pj.molamola.category.presentation.vo.CategoryVO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RequestMapping("/category")
@RestController
public class CategoryController {


    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    /*
       카테고리의 리스트 불러오기
     */
    @GetMapping("/list")
    public String getCategoryList(){

        return "getList";
    }

    /*
        카테고리 생성
     */
    @PostMapping("/create")
    public Boolean createCategory(@RequestBody CategoryVO cateVO){
        boolean ifCreate = categoryService.createCategory(cateVO);
        return ifCreate;
    }

}
