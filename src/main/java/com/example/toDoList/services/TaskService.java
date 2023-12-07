package com.example.toDoList.services;

import com.example.toDoList.models.Task;
import com.example.toDoList.repoiitoyies.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Component
@Scope("singleton")
public class TaskService implements TaskServices{
    @Autowired
    private TaskRepository taskRepository;
    public Iterable<Task> tasks(){
        return taskRepository.findAll();
    };
    public void taskAdd(Task task){ taskRepository.save(task);};
    public Date convertDate(String startDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(startDate);
        return date;
    }
    public ArrayList<Task> findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        ArrayList<Task> tasks= new ArrayList<>();
        task.ifPresent(tasks::add);
        return tasks;
    }


}
