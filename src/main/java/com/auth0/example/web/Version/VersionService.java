package com.auth0.example.web.Version;


import com.auth0.example.model.Projects.Project;
import com.auth0.example.model.Projects.Version;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class VersionService {
    private final Path root = Paths.get("uploads");
    private final RestTemplate restTemplate;

    public VersionService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Version> getAllVersionsbyProject(Long projectid){
        String url = "http://localhost:3000/projects/{projectid}/versions";

        ResponseEntity<Version[]> response =
                restTemplate.getForEntity(
                        url,
                        Version[].class);
        Version[] versions = response.getBody();
        return Arrays.asList(versions);
    }

    public Version[] getVersionByProject(int number , Long projetid){
        String url = "http://localhost:3000/projects/{projectid}/version/{number}";

        ResponseEntity<Version[]> response =
                restTemplate.getForEntity(
                        url,
                        Version[].class);
        Version[] version = response.getBody();
        return version;
    }
    public List<String> getVersionCommentaires(Version version){
        String url = "http://localhost:3000/projects/{project}/version/{number}/commentaires";

        ResponseEntity<String> response =
                restTemplate.getForEntity(
                        url,
                        String.class,version.getProjectid(),version.getNumber());
        String commentaires = response.getBody();
        return Arrays.asList(commentaires);
    }

    public void addVersion(Version version){
        HttpEntity<Version> entity= new HttpEntity<>(version);
        restTemplate.postForObject("http://localhost:3000/projects/{project}/addVersion", entity,Version.class, version.getProjectid());
    }




    public void addCommentaire(@RequestBody Version version, @RequestParam String commentaire ){
        HttpEntity<String> entity = new HttpEntity<>(commentaire);
        restTemplate.postForObject("http://localhost:3000/projects/{project}/version/{number}/addcommentaire", entity,String.class, version.getProjectid(),version.getNumber());
    }


    public void uploadVersion(MultipartFile file){
        try{
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch(Exception e){
            throw new RuntimeException("Could not store the file. Error :" + e.getMessage());
        }
    }

    public Resource loadVersion(String filename){
        try{
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw new RuntimeException("Could not read the file !");
            }
        } catch (MalformedURLException e){
            throw new RuntimeException( "Error : "+ e.getMessage());
        }
    }

    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }




}
