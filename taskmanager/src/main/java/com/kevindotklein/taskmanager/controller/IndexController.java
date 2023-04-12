package com.kevindotklein.taskmanager.controller;

import com.kevindotklein.taskmanager.entity.Task;
import com.kevindotklein.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ModelAndView getAll(){
        List<Task> taskList = this.taskService.findAll();

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("tasklist", taskList);

        return mv;
    }
}
