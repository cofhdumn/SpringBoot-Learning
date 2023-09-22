package com.atguigu.service;

import com.atguigu.pojos.Schedule;
import com.atguigu.result.PageResult;

/**
 * ClassName: ScheduleSservice
 * Package: com.atguigu.service
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/10 15:58
 * @Version 1.0
 */
public interface ScheduleService {


    PageResult<Schedule> findByPage(Integer pageSize,Integer pageNum);

    void deleteById(Integer id);

    void updateSchedule(Schedule schedule);

    void addSchedule(Schedule schedule);

}
