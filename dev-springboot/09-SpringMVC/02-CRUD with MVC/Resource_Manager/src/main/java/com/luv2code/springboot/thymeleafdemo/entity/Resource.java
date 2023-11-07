package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="resource")
public class Resource {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name = "subject")
	private String subject;

	@Column(name="docs")
	private String documentation;
	
	@Column(name="github")
	private String github;
	
	@Column(name="drive")
	private String drive;
	
		
	// define constructors
	
	public Resource() {
		
	}

	public Resource(int id, String subject, String documentation, String github, String drive) {
		this.id = id;
		this.subject = subject;
		this.documentation = documentation;
		this.github = github;
		this.drive = drive;
	}

	public Resource(String subject, String documentation, String github, String drive) {
		this.subject = subject;
		this.documentation = documentation;
		this.github = github;
		this.drive = drive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}
}











