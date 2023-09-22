package com.atguigu;

import com.atguigu.mapper.ScheduleMapper;
import com.atguigu.pojos.Schedule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;

/**
 * ClassName: test
 * Package: com.atguigu
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/10 21:09
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:spring/spring-persist.xml" )
public class test {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Test
    public  void  test01(){
        for (int i =0 ;i< 10; i++){
            Schedule schedule = new Schedule(null, i + "a", false);
            scheduleMapper.addSchedule(schedule);
        }

    }
}
