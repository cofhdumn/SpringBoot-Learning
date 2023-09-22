package com.atguigu.service.impl;

import com.atguigu.annotation.InvokeTime;
import com.atguigu.mapper.ScheduleMapper;
import com.atguigu.pojos.Schedule;
import com.atguigu.result.PageResult;
import com.atguigu.service.ScheduleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: ScheduleServiceImpl
 * Package: com.atguigu.service.impl
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/11 16:45
 * @Version 1.0
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    @Transactional(readOnly = true ,propagation = Propagation.SUPPORTS)
    public PageResult<Schedule> findPage(Integer pageNum, Integer pageSize) {
        //1 .开启分页
        PageHelper.startPage(pageNum,pageSize);
        //2. 执行查询
        List<Schedule> scheduleList = scheduleMapper.findAll();
        //3. 封装分页数据到PageInfo对象中
        PageInfo pageInfo = new PageInfo<>(scheduleList,10);
        //4. 将PageInfo对象中的数据封装到PageResult对象中
        return new PageResult<>(pageInfo.getList(),pageInfo.getPageSize(),pageInfo.getTotal(),pageInfo.getPageNum());

    }

    @Override
    @Transactional
    public void addSchedule(Schedule schedule) {
        scheduleMapper.addSchedule(schedule);
    }

    @Override
    @InvokeTime
    @Transactional
    public void updateSchedule(Schedule schedule) {
    scheduleMapper.updateSchedule(schedule);

    }

    @Override
    @Transactional
    public void deleteScheduleById(Integer id) {
        scheduleMapper.deleteScheduleById(id);

    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Schedule> findScheduleListByCompleted(Boolean completed) {
        return scheduleMapper.findScheduleListByCompleted(completed);
    }

}
