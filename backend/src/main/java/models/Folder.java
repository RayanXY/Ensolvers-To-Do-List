package models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "folders")
public class Folder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy="folder")
	private List<Task> tasks;
	
	// Constructors
	public Folder() {
		// Intentionally left blank
	}
	
	public Folder(String name) {
		this.name = name;
	}

	// Getters
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	// Setters
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Folder-" + id + ": " + name;
	}

}
