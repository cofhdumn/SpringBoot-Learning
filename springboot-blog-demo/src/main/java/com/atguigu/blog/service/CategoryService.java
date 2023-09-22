package com.atguigu.blog.service;

import com.atguigu.blog.pojos.Category;
import com.atguigu.blog.result.PageResult;
import com.atguigu.blog.vos.QueryCategoryVo;

import java.util.List;

/**
 * ClassName: CategoryService
 * Package: com.atguigu.blog.service
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 16:37
 * @Version 1.0
 */
public interface CategoryService {
    /**
     * 查询所有的分类
     * @return
     */
    List<Category> findCategoryList();
    /**
     * 分页查询分类列表
     * @param pageNum
     * @param pageSize
     * @param queryCategoryVo
     * @return
     */

    PageResult<Category> findCategoryPageList(Integer pageNum, Integer pageSize, QueryCategoryVo queryCategoryVo);


    /**
     * 保存分类
     * @param category
     */
    void saveCategory( Category category);

    /**
     * 修改分类
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 根据id删除分类
     * @param id
     */
    void deleteCategoryById(Integer id);
}
