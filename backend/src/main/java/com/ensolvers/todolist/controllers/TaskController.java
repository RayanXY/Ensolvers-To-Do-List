package com.ensolvers.todolist.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.todolist.models.Task;
import com.ensolvers.todolist.repositories.TaskRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	TaskRepository taskRepository;
	
	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getAllTasks(/*@RequestParam(required = false) Folder folder*/) {
		try {
			List<Task> tasks = new ArrayList<Task>();
			
//			if(folder == null) {
				taskRepository.findAll().forEach(tasks::add);			
			/*} else {
				taskRepository.findByFolder(folder).forEach(tasks::add);
			}*/
			
			if(tasks.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(tasks, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id) {
		Optional<Task> taskData = taskRepository.findById(id);
		
		if(taskData.isPresent()) {
			return new ResponseEntity<>(taskData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/tasks")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		try {
			Task new_task = taskRepository.save(new Task(task.getDescription(), /*null,*/ false));
			return new ResponseEntity<>(new_task, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") Integer id, @RequestBody Task task) {
		Optional<Task> taskData = taskRepository.findById(id);
		
		if(taskData.isPresent()) {
			Task new_task = taskData.get();
			new_task.setDescription(task.getDescription());
			new_task.setDone(task.getDone());
			return new ResponseEntity<>(taskRepository.save(new_task), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id") Integer id) {
		try {
			taskRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/tasks")
	public ResponseEntity<HttpStatus> deleteAllTask() {
		try {
			taskRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
