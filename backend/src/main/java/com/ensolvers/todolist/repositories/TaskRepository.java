package com.ensolvers.todolist.repositories;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.ensolvers.todolist.models.Folder;
import com.ensolvers.todolist.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
//	List<Task> findByFolder(Folder folder);
}
