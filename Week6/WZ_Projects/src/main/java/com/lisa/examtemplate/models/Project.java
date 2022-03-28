package com.lisa.examtemplate.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
    
    
@Entity
@Table(name="projects")
public class Project {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Project name is required!")
    @Size(min=3, max=100, message="Project name must be between 3 and 100 characters")
    private String projectName;
    
    @NotEmpty(message="Description is required!")
    @Size(min=3, max=300, message="Description must be between 3 and 300 characters")
    private String description;
    
    @Future
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dueDate;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
  
    /////////////// RELATIONSHIPS ////////////////////////
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;  
    
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="likes", 
        joinColumns=@JoinColumn(name="project_id"), 
        inverseJoinColumns=@JoinColumn(name="user_id")
    )
    private List<User> userLikers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserLikers() {
		return userLikers;
	}

	public void setUserLikers(List<User> userLikers) {
		this.userLikers = userLikers;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	
    

    
}
    