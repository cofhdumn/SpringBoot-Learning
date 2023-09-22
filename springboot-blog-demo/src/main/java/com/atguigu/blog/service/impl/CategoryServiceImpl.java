package com.atguigu.blog.service.impl;

import com.atguigu.blog.mapper.CategoryMapper;
import com.atguigu.blog.pojos.Category;
import com.atguigu.blog.result.PageResult;
import com.atguigu.blog.service.CategoryService;
import com.atguigu.blog.vos.QueryCategoryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: CategoryServiceImpl
 * Package: com.atguigu.blog.service.impl
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 16:39
 * @Version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findCategoryList() {
        return categoryMapper.findCategoryList();
    }

    @Override
    public PageResult<Category> findCategoryPageList(Integer pageNum, Integer pageSize, QueryCategoryVo queryCategoryVo) {
        //1. 开启分页
        PageHelper.startPage(pageNum,pageSize);
        //2. 执行搜索
        List<Category> categoryList = categoryMapper.findCategoryListByCondition(queryCategoryVo);
        //3. 封装成PageInfo对象
        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        //4. 封装成PageResult对象
        return new PageResult<>(categoryList,pageInfo.getTotal()) ;
    }

    @Override
    public void saveCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        categoryMapper.deleteCategoryById(id);
    }
}
