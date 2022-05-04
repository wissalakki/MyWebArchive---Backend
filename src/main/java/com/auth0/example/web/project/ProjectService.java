package com.auth0.example.web.project;

import com.auth0.example.model.Projects.Project;
import com.auth0.example.model.Users.Prof;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProjectService {


    public List<Project> getAllProjects(){
        return null;
    }


    public Project getProjectByKeyWords( List<String> keyWords){
        return null;
    }

    public Project getProjectByProjectType(@RequestParam("type") String type){
        return null;
    }

    public Project getProjectByStudent(@RequestParam("name") String name, @RequestParam("level") String level){
        return null;
    }

    public void addProject(@RequestParam("title") String title, List<String> keyWords){

    }

    public void assignProfessor(@RequestBody Prof supervisor){

    }

    public void changeStatus(@RequestParam("status") String status){

    }

    public void updateVersion(String title){

    }
    public void rateProject(int note){

    }
}
