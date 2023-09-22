package com.atguigu.service;

import com.atguigu.pojos.Schedule;
import com.atguigu.result.PageResult;

import java.util.List;

/**
 * ClassName: ScheduleService
 * Package: com.atguigu.service
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/11 16:42
 * @Version 1.0
 */
public interface ScheduleService {

    PageResult<Schedule> findPage(Integer pageNum ,Integer pageSize);

    void addSchedule(Schedule schedule);

    void updateSchedule(Schedule schedule);

    void deleteScheduleById(Integer id);

    List<Schedule> findScheduleListByCompleted(Boolean completed);
}
