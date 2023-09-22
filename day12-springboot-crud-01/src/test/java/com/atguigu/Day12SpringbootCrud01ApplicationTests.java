package com.atguigu;

import com.atguigu.mapper.ScheduleMapper;
import com.atguigu.pojos.Schedule;
import com.atguigu.result.PageResult;
import com.atguigu.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class Day12SpringbootCrud01ApplicationTests {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Autowired
    private ScheduleService scheduleService;

    @Test
    public  void testDaoFindAll() {
        log.info(scheduleMapper.findAll().toString());
    }


    @Test
    public void testFindPage(){
     PageResult<Schedule> pageResult =  scheduleService.findPage(1,10);
    log.info("查询到的分页数据是:{}",pageResult);
    }
}
