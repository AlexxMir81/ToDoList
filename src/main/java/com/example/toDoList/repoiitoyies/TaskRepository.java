package com.example.toDoList.repoiitoyies;

import com.example.toDoList.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
