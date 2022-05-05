package com.auth0.example.web.project;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/projects", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

    private ProjectService projectService;
}
