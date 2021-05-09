package com.ensolvers.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensolvers.todolist.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	// Intentionally left blank
}
