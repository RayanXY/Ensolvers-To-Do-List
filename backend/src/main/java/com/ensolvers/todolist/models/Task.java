package com.ensolvers.todolist.models;

import javax.persistence.*;

//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="folder_id", nullable = true)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private Folder folder;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "done")
	private boolean done;
	
	// Constructors
	public Task() {
		// Intentionally left blank
	}
	
	public Task(String description, /*Folder folder,*/ boolean done) {
		this.description = description;
//		this.folder = folder;
		this.done = done;
	}
	
	// Getters
	public Integer getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getDone() {
		return done;
	}
	
	// Setters
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	@Override
	public String toString() {
		return "Task-" + id + ": " + description + " [" + done + "]";
	}
	
}
