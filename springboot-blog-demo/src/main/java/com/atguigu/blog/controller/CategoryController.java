package com.atguigu.blog.controller;

import com.atguigu.blog.pojos.Category;
import com.atguigu.blog.result.PageResult;
import com.atguigu.blog.result.Result;
import com.atguigu.blog.service.CategoryService;
import com.atguigu.blog.vos.QueryCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: CategoryController
 * Package: com.atguigu.blog.controller
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 18:08
 * @Version 1.0
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/queryList")
    public Result<List<Category>> queryList(){
        return Result.ok(categoryService.findCategoryList());
    }


    @PostMapping("/queryListPage/{pageNum}/{pageSize}")
    public Result<PageResult<Category>> queryListPage(@PathVariable("pageNum") Integer pageNum ,
                                                      @PathVariable("pageSize") Integer pageSize,
                                                      @RequestBody QueryCategoryVo queryCategoryVo){
        return Result.ok(categoryService.findCategoryPageList(pageNum,pageSize,queryCategoryVo));
    }

    @PostMapping("/addCategory")
    public Result addCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
        return Result.ok();
    }

    @PutMapping("/updateCategory")
    public Result updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
        return Result.ok();
    }

    @DeleteMapping("/deleteCategory/{id}")
    public Result deleteCategoryById(@PathVariable("id") Integer id){
        categoryService.deleteCategoryById(id);
        return Result.ok();
    }
}
