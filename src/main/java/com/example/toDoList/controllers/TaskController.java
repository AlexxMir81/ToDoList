package com.example.toDoList.controllers;

import com.example.toDoList.models.Task;
import com.example.toDoList.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Controller
public class TaskController {
    @Autowired
    private TaskServices taskService;
    @GetMapping("/tasks")
    public String task(Model model){
        model.addAttribute("tasks", taskService.tasks());
        return "tasks";
    }
    @GetMapping("/task/add")
    public String taskAdd(Model model){
        return "taskAdd";
    }
    @PostMapping("/task/add")
    public String taskAddPost(@RequestParam String title, @RequestParam String description,
        @RequestParam String startDate, @RequestParam String duration, Model model) throws ParseException {
        Task task = new Task(title, description, taskService.convertDate(startDate), Integer.parseInt(duration));
        taskService.taskAdd(task);
        return "redirect:/tasks";
    }
    @GetMapping("/task/{id}")
    public String tasksDetail(@PathVariable(value = "id") Long id, Model model){
        if(!(taskService.findById(id).size()>0)){return  "redirect:/tasks";};
        model.addAttribute("tasks", taskService.findById(id));
        return "taskDetail";
    }
    @GetMapping("/task/{id}/edit")
    public String tasksEdit(@PathVariable(value = "id") Long id, Model model){
        if(!(taskService.findById(id).size()>0)){return  "redirect:/tasks";};
        model.addAttribute("tasks", taskService.findById(id));
        return "taskEdit.html";
    }
}
