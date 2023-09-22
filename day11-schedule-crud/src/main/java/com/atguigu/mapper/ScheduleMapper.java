package com.atguigu.mapper;

import com.atguigu.pojos.Schedule;

import java.util.List;

/**
 * ClassName: ScheduleMapper
 * Package: com.atguigu.mapper
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/10 15:54
 * @Version 1.0
 */
public interface ScheduleMapper {
    List<Schedule> findAll();

    void deleteById(Integer id);

    void updateSchedule(Schedule schedule);

    void addSchedule(Schedule schedule);
}
