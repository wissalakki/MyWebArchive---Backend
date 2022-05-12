package com.auth0.example.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auth0.example.web.ReclamationService;

@RestController
@RequestMapping(path = "api/reclamation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReclamationController {

    private ReclamationService reclamationService;


}
