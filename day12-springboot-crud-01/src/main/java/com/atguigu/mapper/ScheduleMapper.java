package com.atguigu.mapper;

import com.atguigu.pojos.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: ScheduleMapper
 * Package: com.atguigu.mapper
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/11 15:50
 * @Version 1.0
 */
@Mapper
public interface ScheduleMapper {

    List<Schedule> findAll();

    void updateSchedule(Schedule schedule);

    void addSchedule(Schedule schedule);

    void deleteScheduleById(Integer id);

    List<Schedule> findScheduleListByCompleted(Boolean completed);

}
