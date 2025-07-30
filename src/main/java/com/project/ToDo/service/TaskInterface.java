package com.project.ToDo.service;

import com.project.ToDo.model.Task;

import java.util.List;

public interface TaskInterface {
    Task createTask(Task task);
    List<Task> getAllTask();
    Task getTaskById(Long taskId);
    Task updateTask(Task task);
    void deleteTaskByID(Long taskId);

}
