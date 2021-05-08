package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Folder;
import models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	List<Task> findByFolder(Folder folder);
}
