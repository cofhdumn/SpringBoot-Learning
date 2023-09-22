package com.atguigu.controller;

import com.atguigu.pojos.Schedule;
import com.atguigu.result.Result;
import com.atguigu.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;


    @GetMapping
    public Result findAll() {
        List<Schedule> all = scheduleService.findAll();
        return Result.ok(all);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Integer id){
        scheduleService.deleteScheduleById(id);

        return Result.ok();
    }


    @PutMapping
    public Result updateById(@RequestBody Schedule schedule){

        scheduleService.updateSchedule(schedule);
        return Result.ok();
    }


    @PostMapping
    public Result addSchedule(@RequestBody Schedule schedule){
        scheduleService.addSchedule(schedule);
        return Result.ok();
    }
}
