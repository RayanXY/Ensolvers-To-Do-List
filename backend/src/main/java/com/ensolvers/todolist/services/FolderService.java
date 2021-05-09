package com.ensolvers.todolist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ensolvers.todolist.models.Folder;
import com.ensolvers.todolist.repositories.FolderRepository;

@CrossOrigin
@Service
public class FolderService {
	
	@Autowired
	FolderRepository folderRepository;
	
	// Returns all folders
	public List<Folder> getAllFolder() {
		return folderRepository.findAll();
	}
	
	// Save a folder
	public void save(Folder folder) {
		folderRepository.save(folder);
	}
	
	// Update a folder
	public void update(Folder folder) {
		folder.setName(folder.getName());
		folderRepository.save(folder);
	}
	
	// Delete a folder
	public void delete(Integer id) {
		folderRepository.deleteById(id);
	}
	
}
