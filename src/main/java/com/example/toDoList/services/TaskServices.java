package com.example.toDoList.services;

import com.example.toDoList.models.Task;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public interface TaskServices {
     Iterable<Task> tasks();
     void taskAdd(Task task);
     Date convertDate(String startDate) throws ParseException;
     ArrayList<Task> findById(Long id);
}
