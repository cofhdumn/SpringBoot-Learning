package com.atguigu.service.impl;

import com.atguigu.dao.ScheduleDao;
import com.atguigu.pojos.Schedule;
import com.atguigu.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;
    @Override
    public List<Schedule> findAll() {
        return scheduleDao.findAll();
    }
}
