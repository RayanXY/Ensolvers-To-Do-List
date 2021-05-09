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

import com.ensolvers.todolist.models.Folder;
import com.ensolvers.todolist.services.FolderService;


@CrossOrigin
@RestController
@RequestMapping("/folders")
public class FolderController {
	
	@Autowired
	FolderService folderService;
	
	// Gets all folders
	@GetMapping
	public List<Folder> getAll() {
		return folderService.getAllFolder();
	}
	
	// Save a new folders
	@PostMapping
	public void saveTask(@RequestBody Folder folder) {
		folderService.save(folder);
	}
	
	// Update a folder
	@PutMapping
	public void update(@RequestBody Folder folder) {
		folderService.update(folder);
	}
	
	// Delete a task by Id
	@DeleteMapping("/{id}")
	public void delteTask(@PathVariable("id") Integer id) {
		folderService.delete(id);
	}

}
