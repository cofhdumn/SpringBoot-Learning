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

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Schedule.class));
    }

    @Override
    public void deleteScheduleById(Integer scheduleId) {
        String sql = "delete from  t_schedule where id =?";
        jdbcTemplate.update(sql,scheduleId);
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        String sql = "update t_schedule  set title =? ,completed=? where id=? ";
        jdbcTemplate.update(sql,schedule.getTitle(),schedule.getCompleted(),schedule.getId());
    }

    @Override
    public void addSchedule(Schedule schedule) {

        String sql = "INSERT INTO t_schedule(title,completed) VALUES(?,?)";
        jdbcTemplate.update(sql,schedule.getTitle(),schedule.getCompleted());
    }
}
