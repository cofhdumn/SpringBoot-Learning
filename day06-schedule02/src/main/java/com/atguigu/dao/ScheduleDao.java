package com.atguigu.dao;

import com.atguigu.pojos.Schedule;

import java.util.List;

public interface ScheduleDao {

    /**
     * 查询所有计划
     * @return
     */

    List<Schedule> findAll();


    /**
     * 根据计划id删除计划
     * @param scheduleId
     */

    void deleteScheduleById(Integer scheduleId);


    /**
     * 修改计划
     * @param schedule
     */

    void updateSchedule(Schedule schedule);

    /**
     * 添加计划
     * @param schedule
     */

    void addSchedule(Schedule schedule);
}
