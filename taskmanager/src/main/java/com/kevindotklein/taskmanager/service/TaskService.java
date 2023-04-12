package com.kevindotklein.taskmanager.service;

import com.kevindotklein.taskmanager.entity.Task;
import com.kevindotklein.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void save(Task task){
        this.taskRepository.save(task);
    }

    public List<Task> findAll(){
        return this.taskRepository.findAll();
    }

    public Task findById(Long id){
        return this.taskRepository.findById(id).get();
    }

    public void deleteById(Long id){
        this.taskRepository.deleteById(id);
    }
}
