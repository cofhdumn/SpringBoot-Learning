package com.atguigu.blog.mapper;

import com.atguigu.blog.pojos.Category;
import com.atguigu.blog.vos.QueryCategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: CategoryMapper
 * Package: com.atguigu.blog.mapper
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 16:11
 * @Version 1.0
 */
@Mapper
public interface CategoryMapper {

    /**
     * 查询所有的分类
     * @return
     */
    List<Category> findCategoryList();


    /**
     * 根据条件搜索分类列表
     * @param queryCategoryVo
     * @return
     */
    List<Category> findCategoryListByCondition(QueryCategoryVo queryCategoryVo);

    /**
     * 添加分类
     * @param category
     */
    void addCategory(Category category);
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
