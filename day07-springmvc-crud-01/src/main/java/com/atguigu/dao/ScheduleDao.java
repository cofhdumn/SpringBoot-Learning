package com.atguigu.dao;

import com.atguigu.pojos.Schedule;

import java.util.List;

public interface ScheduleDao {
    List<Schedule> findAll();
}
