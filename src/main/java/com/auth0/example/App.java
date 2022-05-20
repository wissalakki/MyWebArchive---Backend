package com.auth0.example;

import com.auth0.example.web.Version.FileStorageProperties;
import com.auth0.example.web.Version.VersionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.Resource;

/**
 * Main entry point of application.
 */
@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class App  {



    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}
