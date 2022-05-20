package com.auth0.example.web.project;

import com.auth0.example.model.Enums.StatusProjet;
import com.auth0.example.model.Enums.TypeProjet;
import com.auth0.example.model.Projects.Project;
import com.auth0.example.security.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
//@RequestMapping(path = "api/projects", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {



    private Utils utils;
    private ProjectService projectService;

    public ProjectController(ProjectService projectService, Utils utils ){
        this.projectService = projectService;
        this.utils =utils;
    }

    @GetMapping(value = "/projects")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping(value="/projects/{projectid}")
    public Project getProject(@RequestHeader String authHeader,@RequestParam("projectid") Long projectId){
        String user =this.utils.getUser(authHeader);
        return projectService.getProjectbyId(authHeader,projectId);
    }

    @GetMapping("/teachers/{id}/projects")
    public List<Project> getAllProjectsSupervisedByTeacher(@PathVariable Long id){
        return projectService.getAllProjectsTeacher(id);
    }

    @GetMapping("/students/{id}/projects")
    public List<Project> getAllProjectsByStudent(@PathVariable Long id){
        return projectService.getProjectByStudent(id);
    }


    @GetMapping("/projects/{keywords}")
    public List<Project> getProjectsByKeyword(@PathVariable List<String> keywords){
         return projectService.getProjectByKeyWords(keywords);
    }

    @GetMapping("/projects/{type}")
    public List<Project> getProjectsByType(@PathVariable TypeProjet type){
        return projectService.getProjectByProjectType(type);
    }


    @PostMapping(value="/addproject")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProject(@RequestBody Project project){
        projectService.addProject(project);
    }

   // @PutMapping("/projects/changeStatus/{projectid}&{status}")
    //public void changeStatusOfProject(@RequestParam("projectid") Long projectid, @RequestParam("status") StatusProjet status){
      //  projectService.changeStatus(status,projectid);
    //}

    //@GetMapping(value="projects/{projectid}/{rate}")
    //public void rateProject(@RequestHeader String user, @RequestParam("projectid") Long projectid, @RequestParam )



}