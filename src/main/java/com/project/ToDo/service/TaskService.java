package com.project.ToDo.service;

import com.project.ToDo.model.Task;
import com.project.ToDo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements TaskInterface{
    @Autowired
    private TaskRepository taskRep;

    @Override
    public List<Task> getAllTask() {
        return taskRep.findAll();
    }
    @Override
    public Task createTask(Task task)
    {
        return taskRep.save(task);
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRep.findById(taskId).orElseThrow();
    }

    @Override
    public Task updateTask(Task task) {
        Task existing=getTaskById(task.getTaskId());
        if(existing !=null) {
            existing.setTaskId(task.getTaskId());
            existing.setTitle(task.getTitle());
            existing.setDescription(task.getDescription());
            return taskRep.save(existing);
        }
        else
            return null;
    }

    @Override
    public void deleteTaskByID(Long taskId) {
        taskRep.deleteById(taskId);
    }


    public boolean existsTaskById(Long taskId) {
        return taskRep.existsById(taskId);
    }
}
