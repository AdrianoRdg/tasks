package com.adrianordg.todolist.task;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping()
    public TaskModel create(@RequestBody TaskModel task, HttpServletRequest request) {
        UUID userId = (UUID) request.getAttribute("userId");
        task.setUserId(userId);

        return this.taskRepository.save(task);
    }
}