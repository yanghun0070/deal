package com.num6pj.molamola.category.presentation.api;

import com.num6pj.molamola.board.domain.Board;
import com.num6pj.molamola.category.application.CategoryService;
import com.num6pj.molamola.category.domain.Category;
import com.num6pj.molamola.category.presentation.vo.CategoryVo;
import com.num6pj.molamola.user.domain.UserInfo;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/category")
@RestController
public class CategoryApiController {


    private CategoryService categoryService;

    public CategoryApiController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    /**
     * 카테고리 생성
     * @todo 관리자만 카테고리 생성할 건지, 결정
     * @param category
     */
    @PostMapping("create")
    public void createCategory(@RequestBody CategoryVo category,
                               @AuthenticationPrincipal UserInfo userInfo){
        System.out.println(category.getName() + category.getUserName());
        /*
        / TODO.userInfo 인증된 아이디를 지정해줘야 함
         */

        categoryService.createCategory(new ModelMapper().map(
                category, Category.class), userInfo.getUsername());
    }
    /*
    Dev Version

     */
    @PostMapping("createDev")
    public void createdevCategory(@RequestBody CategoryVo category,
                               @AuthenticationPrincipal UserInfo userInfo){
        System.out.println(category.getName() + category.getUserName());
        /*
        / TODO.userInfo 인증된 아이디를 지정해줘야 함
         */
        categoryService.createCategory(new ModelMapper().map(
                category, Category.class), "admin");
    }


    @GetMapping("list")
    public List<Category> getCategoryList(){
        System.out.println("Request Get Category List");
        return categoryService.getCategoryList();
    }

    @GetMapping("{id}/boards")
    public List<Board> getCategoryBoards( @PathVariable Long id){
        return categoryService.getCategoryBoards(id);
    }

}
