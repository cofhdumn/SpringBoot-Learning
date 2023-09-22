package com.atguigu.task;

import com.atguigu.pojos.Schedule;
import com.atguigu.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: ScheduleTask
 * Package: com.task
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/11 18:39
 * @Version 1.0
 */
@Component
@Slf4j
public class ScheduleTask {
//定时任务
    @Autowired
    private ScheduleService scheduleService;

    @Scheduled(cron = "0 0 12 * * ? ")
    public void notifyUserToCompleteSchedule(){
        //1. 获取所有未完成的学习计划
     List<Schedule>  scheduleList =  scheduleService.findScheduleListByCompleted(false);
        //2. 通知用户完成这些学习计划(使用日志模拟)
        log.info("你好，请按时完成学习任务{}",scheduleList);

    }
}
