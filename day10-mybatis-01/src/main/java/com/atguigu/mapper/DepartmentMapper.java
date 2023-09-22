package com.atguigu.mapper;

import com.atguigu.pojos.Department;

/**
 * ClassName: DepartmentMapper
 * Package: com.atguigu.mapper
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/9 20:50
 * @Version 1.0
 */
public interface DepartmentMapper {
    /**
     * 根据部门id查询部门信息,并且查询部门下的所有员工信息
     * @param did
     * @return
     */

    Department findDepartmentWithEmployeeListById(Integer did);
}
