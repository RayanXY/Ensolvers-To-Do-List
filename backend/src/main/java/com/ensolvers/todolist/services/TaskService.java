package com.ensolvers.todolist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ensolvers.todolist.models.Task;
import com.ensolvers.todolist.repositories.TaskRepository;

@CrossOrigin
@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	// Returns all tasks
	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}
	
	// Save a task
	public void save(Task task) {
		taskRepository.save(task);
	}
	
	// Update a task
	public void update(Task task) {
		task.setDone(!task.getDone());
		task.setDescription(task.getDescription());
		taskRepository.save(task);
	}
	
	// Delete a task
	public void delete(Integer id) {
		taskRepository.deleteById(id);
	}
	
}
