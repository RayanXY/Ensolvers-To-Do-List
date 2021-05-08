package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer> {

}
