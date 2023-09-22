package com.atguigu.dao.impl;

import com.atguigu.dao.DepartmentDao;
import com.atguigu.pojos.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 包名:com.atguigu.dao.impl
 *
 * @author Leevi
 * 日期2023-08-29  14:20
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addDepartment(Department department) {
        String sql = "INSERT INTO t_department (dname,description) VALUES (?,?)";
        jdbcTemplate.update(sql,department.getDname(),department.getDescription());
    }
}
