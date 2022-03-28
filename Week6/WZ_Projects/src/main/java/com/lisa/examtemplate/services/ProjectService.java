package com.lisa.examtemplate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisa.examtemplate.models.Project;
import com.lisa.examtemplate.models.User;
import com.lisa.examtemplate.repositories.ProjectRepo;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepo projectRepo;
	
	
	// returns all the projects
	public List<Project> allProjects() {
		return projectRepo.findAll();
	}
	
    // creates a project
    public Project createProject(Project newProject) {
        return projectRepo.save(newProject);
    }
    
	// retrieve one project
	public Project findProjectById(Long id) {
		return projectRepo.findById(id).orElse(null);
	}
    
    // updates the project
    public Project updateProject(Project updatedProject) {
    	return projectRepo.save(updatedProject);
    }
    
    // deletes the project
    public void deleteProject(Long id) {
    	Optional<Project> deleteProjectAction = projectRepo.findById(id);
    	if(deleteProjectAction.isPresent()) {
    		projectRepo.deleteById(id);
    	} 
    	else {
    		System.out.println("Failed to delete");
    	}
    }
    
    
    //////////// LIKES/DISLIKE //////////////
    public void likeProject(Project project, User user) {
    	List<User> userLikers=project.getUserLikers();
    	userLikers.add(user);
    	projectRepo.save(project);
    }
    
    public void dislikeProject(Project project, User user) {
    	List<User> userLikers=project.getUserLikers();
    	userLikers.remove(user);
    	projectRepo.save(project);
    }
    
    
    
}
