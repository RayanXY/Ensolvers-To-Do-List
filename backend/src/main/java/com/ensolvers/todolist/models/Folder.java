package com.ensolvers.todolist.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "folders")
public class Folder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy="folder", cascade=CascadeType.ALL)
	private List<Task> tasks;
	
	// Constructors
	public Folder() {
		// Intentionally left blank
	}
	
	public Folder(String bane) {
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
