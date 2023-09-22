package com.atguigu.service.impl;

import com.atguigu.dao.DepartmentDao;
import com.atguigu.pojos.Department;
import com.atguigu.service.DepartmentService;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 包名:com.atguigu.service.impl
 *
 * @author Leevi
 * 日期2023-08-29  14:21
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public void addDepartment(Department department) {
        //1. 新增部门信息
        departmentDao.addDepartment(department);

        //2. 删除用户信息
        userService.deleteUserById(7);

        int num = 10/0;
    }
}
