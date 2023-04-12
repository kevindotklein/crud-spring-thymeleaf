package com.kevindotklein.taskmanager.controller;

import com.kevindotklein.taskmanager.entity.Author;
import com.kevindotklein.taskmanager.entity.Task;
import com.kevindotklein.taskmanager.service.AuthorService;
import com.kevindotklein.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("tasks/form")
public class TaskController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/add")
    public ModelAndView getForm(){
        ModelAndView mv = new ModelAndView("taskform");
        List<Author> authorList = this.authorService.findAll();
        mv.addObject("authorlist", authorList);
        return  mv;
    }

    @PostMapping("/save")
    public String saveForm(@Valid Task task, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            redirect.addFlashAttribute("error_msg", "complete all fields");
            return "redirect:/tasks/form/add";
        }

        this.taskService.save(task);

        return "redirect:/";
    }

    // TODO: put method
    @GetMapping("/edit/{id}")
    public ModelAndView getEdit(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("taskform");
        List<Author> authorList = this.authorService.findAll();
        mv.addObject("authorlist", authorList);

        mv.addObject("task", this.taskService.findById(id));
        return mv;
    }

    //TODO: delete method
    @GetMapping("/delete/{id}")
    public String getDelete(@PathVariable Long id){
        this.taskService.deleteById(id);

        return "redirect:/";
    }
}
