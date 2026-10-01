package com.school.studenttaskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.studenttaskmanager.model.Task;
import com.school.studenttaskmanager.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    // Add Task
    public Task addTask(Task task) {
        return repository.save(task);
    }

    // View All Tasks
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    // View One Task
    public Task getTaskById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update Task
    public Task updateTask(Long id, Task updatedTask) {

        Task existingTask = repository.findById(id).orElse(null);

        if (existingTask != null) {

            existingTask.setStudentName(updatedTask.getStudentName());
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setStatus(updatedTask.getStatus());

            return repository.save(existingTask);
        }

        return null;
    }

    // Delete Task
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}