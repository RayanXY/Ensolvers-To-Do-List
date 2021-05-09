package com.ensolvers.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.todolist.models.Task;
import com.ensolvers.todolist.services.TaskService;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	// Gets all tasks
	@GetMapping
	public List<Task> getAll() {
		return taskService.getAllTask();
	}
	
	// Save a new tasks
	@PostMapping
	public void saveTask(@RequestBody Task task) {
		taskService.save(task);
	}
	
	// Update a task
	@PutMapping
	public void update(@RequestBody Task task) {
		taskService.update(task);
	}
	
	// Delete a task by Id
	@DeleteMapping("/{id}")
	public void delteTask(@PathVariable("id") Integer id) {
		taskService.delete(id);
	}
	
}
