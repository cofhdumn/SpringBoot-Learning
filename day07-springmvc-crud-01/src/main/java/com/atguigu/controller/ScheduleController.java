package com.atguigu.controller;

import com.atguigu.pojos.Schedule;
import com.atguigu.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public String FindAll(Model model) {
        List<Schedule> scheduleList = scheduleService.findAll();
        model.addAttribute("scheduleList",scheduleList);

        return "list";

    }
}
