package com.atguigu.dao.impl;

import com.atguigu.dao.ScheduleDao;
import com.atguigu.pojos.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Schedule> findAll() {
        String sql = "select * from t_schedule";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Schedule.class));
    }
}
