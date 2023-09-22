package com.atguigu.service.impl;

import com.atguigu.mapper.ScheduleMapper;
import com.atguigu.pojos.Schedule;
import com.atguigu.result.PageResult;
import com.atguigu.service.ScheduleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ScheduleServiceImpl
 * Package: com.atguigu.service.impl
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/10 16:05
 * @Version 1.0
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public PageResult<Schedule> findByPage(Integer pageSize, Integer pageNum) {
        //1. 开启分页
        PageHelper.startPage(pageNum,pageSize);
        //2. 执行查询
        List<Schedule> scheduleList = scheduleMapper.findAll();
        //3. 封装到PageInfo对象中  10表示页码数
        PageInfo<Schedule> pageInfo = new PageInfo<>(scheduleList, 10);
        //4. 创建PageResult对象     // pageSize 每页的数量
        PageResult<Schedule> pageResult = new PageResult<>(pageInfo.getList(), pageInfo.getPageSize(), pageInfo.getTotal(), pageInfo.getPageNum());
        //返回pageResult
        return pageResult;
    }

    @Override
    public void deleteById(Integer id) {
        scheduleMapper.deleteById(id);
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        scheduleMapper.updateSchedule(schedule);
    }

    @Override
    public void addSchedule(Schedule schedule) {
        scheduleMapper.addSchedule(schedule);
    }
}
