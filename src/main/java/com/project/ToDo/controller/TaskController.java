package com.project.ToDo.controller;

import com.project.ToDo.model.Task;
import com.project.ToDo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        if(taskService.existsTaskById(task.getTaskId()))
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("TASK IS ALREADY EXISTED");
        }
        Task created = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @GetMapping
    public ResponseEntity<List<Task>> getAllTask()
    {
        List<Task> getAllTask=taskService.getAllTask();
        return   ResponseEntity.ok(getAllTask);
    }
    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task)
    {
        Task updatedTask=taskService.updateTask(task);
        return ResponseEntity.ok(updatedTask);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id)
    {
        Task getTask=taskService.getTaskById(id);
        return ResponseEntity.ok(getTask);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteById(@PathVariable Long id)
    {
        taskService.deleteTaskByID(id);
        return ResponseEntity.noContent().build();
    }
}
