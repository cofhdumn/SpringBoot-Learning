package com.atguigu.controller;

import com.atguigu.groups.AddGroup;
import com.atguigu.groups.UpdateGroup;
import com.atguigu.pojos.Schedule;
import com.atguigu.result.PageResult;
import com.atguigu.result.Result;
import com.atguigu.service.ScheduleService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ScheduleController
 * Package: com.atguigu.controller
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/11 18:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{pageSize}/{pageNum}")
    public Result<PageResult<Schedule>> findPage(@PathVariable("pageSize") Integer pageSize,
                                                 @PathVariable("pageNum") Integer pageNum){
        return Result.ok(scheduleService.findPage(pageNum,pageSize));
    }


    @PostMapping
    public Result addSchedule(@Validated(AddGroup.class) @RequestBody Schedule schedule){
        scheduleService.addSchedule(schedule);
        return Result.ok();
    }


    @PutMapping
    public Result updateSchedule(@Validated(UpdateGroup.class)@RequestBody Schedule schedule){
        scheduleService.updateSchedule(schedule);
        return Result.ok();
    }



    @DeleteMapping("/{id}")
    public Result deleteScheduleById(@PathVariable("id") Integer id){
        scheduleService.deleteScheduleById(id);
        return Result.ok();
    }
}
