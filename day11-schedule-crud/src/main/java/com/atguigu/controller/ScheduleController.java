package com.atguigu.controller;

import com.atguigu.pojos.Schedule;
import com.atguigu.result.PageResult;
import com.atguigu.result.Result;
import com.atguigu.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ScheduleController
 * Package: com.atguigu.controller
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/10 16:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;


    @GetMapping("/{pageSize}/{pageNum}")
    public Result<PageResult> findByPage(@PathVariable("pageSize") Integer pageSize, @PathVariable("pageNum") Integer pageNum){
        //1. 调用service层的方法查询分页数据
        PageResult<Schedule> pageResult =    scheduleService.findByPage(pageSize,pageNum);
        return Result.ok(pageResult);
    }


    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Integer id){
        scheduleService.deleteById(id);
        return Result.ok();
    }


    @PutMapping
    public Result updateSchedule(@RequestBody Schedule schedule){
        scheduleService.updateSchedule(schedule);
        return Result.ok();
    }



    @PostMapping
    public Result addSchedule(@RequestBody Schedule schedule){
        scheduleService.addSchedule(schedule);
        return Result.ok();
    }
}
