package com.ensolvers.todolist.models;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "done")
	private boolean done;
	
	// Constructors
	public Task() {
		// Intentionally left blank
	}
	
	public Task(String description, boolean done) {
		this.description = description;
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
