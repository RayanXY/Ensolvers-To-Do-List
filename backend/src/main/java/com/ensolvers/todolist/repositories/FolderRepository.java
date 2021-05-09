package com.ensolvers.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensolvers.todolist.models.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer> {

}
