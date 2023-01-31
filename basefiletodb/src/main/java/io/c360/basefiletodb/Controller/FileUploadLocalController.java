package io.c360.basefiletodb.Controller;

import io.c360.basefiletodb.Entity.FileUploadResponse;
import io.c360.basefiletodb.Services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.print.attribute.standard.Media;

@RestController
public class FileUploadLocalController {



    public FileUploadService fileUploadService;

    public FileUploadLocalController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("single/upload")
    FileUploadResponse singleFileUpload(@RequestParam("file")MultipartFile file){
        String filename=fileUploadService.storeFile(file);

        //http://localhost:8064/download/filename.txt
        String url= ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(filename)
                .toUriString();

        String contentType=file.getContentType();

        FileUploadResponse fileUploadResponse=new FileUploadResponse(filename,contentType,url);


        return fileUploadResponse;
    }

    @RequestMapping("/downloads/{file}")
    ResponseEntity<Resource>downloadFilename(@PathVariable String FileName)
    {
     Resource resource=fileUploadService.downloadFile(FileName);
     MediaType contentType= MediaType.APPLICATION_PDF;

        return ResponseEntity.ok()
                .contentType(contentType)
                .header(HttpHeaders.CONTENT_DISPOSITION,"inline;FileName="+resource.getFilename() )
                .body(resource);
    }
}
