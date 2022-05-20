package com.auth0.example.web.Version;


import com.auth0.example.model.Projects.Project;
import com.auth0.example.model.Projects.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.util.List;

@RestController
public class VersionController {

    @Autowired
    public VersionService versionservice;
    @Autowired
    public FileStorageService fileStorageService;

    @GetMapping("/h")// by projectid
    public String h(){
        return "f";
    }

    @GetMapping("/projects/{projectid}/versions")// by projectid
    public List<Version> getAllVersionsbyProject(@RequestBody Long projectid){
        return versionservice.getAllVersionsbyProject(projectid);
    }

    @GetMapping("/projects/{projectid}/versions/{number}")
    public Version[] getVersionByProject(@RequestParam ("projectid") Long project, @RequestParam ("number") int number){
        return versionservice.getVersionByProject(number, project);
    }

    @GetMapping("/projects/{projectid}/version/{number}/commentaires")
    public List<String> getVersionCommentaires(@RequestParam long projectid, @RequestParam("number") int number ){
        return null ;
    }

    @PostMapping("/projects/{projectid}/uploadversion/{number}&{version}")
    public ResponseEntity  uploadAndaddVersion(@RequestParam ("version") MultipartFile version,@RequestParam("number") int number,@RequestParam("projectid") Long projectid ){
        String message = "";
            try{
               versionservice.uploadVersion(version);
               message ="upload done successfully ";
               Version v = new Version(number, null, version.getOriginalFilename(), projectid);
               versionservice.addVersion(v);
               return ResponseEntity.status(HttpStatus.OK).body(message);
            }catch (Exception e){
                message ="could not upload file ";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }

    }

  /*  @PostMapping(value="/upload")

    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            versionservice.save(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/uploading")
    public ResponseEntity<?> handleFileUpload( @RequestParam("file") MultipartFile file ) {

        String fileName = file.getOriginalFilename();
        try {
            file.transferTo( new File("C:\\uploads\\" + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("File uploaded successfully.");
    }*/
  @PostMapping("/uploadFile")
  public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
      String fileName = fileStorageService.storeFile(file);

      String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
              .path("/downloadFile/")
              .path(fileName)
              .toUriString();

      return new UploadFileResponse(fileName, fileDownloadUri,
              file.getContentType(), file.getSize());
  }

}
