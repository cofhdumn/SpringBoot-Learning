package com.atguigu.service;

import com.atguigu.pojos.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAll();

    void deleteScheduleById(Integer scheduleId);

    void updateSchedule(Schedule schedule);

    void addSchedule(Schedule schedule);

}
