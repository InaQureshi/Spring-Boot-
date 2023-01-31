package io.c360.basefiletodb.Controller;

import com.google.gson.Gson;
import io.c360.basefiletodb.Entity.DocumentDB;
import io.c360.basefiletodb.Entity.FileUploadResponse;
import io.c360.basefiletodb.Services.DocumentFileService;
import io.c360.basefiletodb.Services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class FileUploadDBController {

    //public FileUploadService fileUploadService;

    @Autowired
    private DocumentFileService documentFileService;

    public FileUploadDBController(DocumentFileService documentFileService) {
        this.documentFileService = documentFileService;
    }

    String line="";

    @PostMapping("single/uploaddb")
    FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {

        DocumentDB documentDB1 = new DocumentDB();
        String name = StringUtils.cleanPath(file.getOriginalFilename());

        documentDB1.setFilename(name);

        documentDB1.setDocfile(file.getContentType());

        BufferedReader bufferedReader=new BufferedReader(new FileReader(String.valueOf(file.getBytes())));
        while((line=bufferedReader.readLine()).isEmpty())
        {

            String[] data=line.split(",");
            DocumentDB documentDB = new DocumentDB();
            final String textData="This Text To Be Encoded ";
            String encodedtext= Base64.getEncoder().encodeToString(textData.getBytes(StandardCharsets.UTF_8));
            System.out.println("Encoded Text : "+encodedtext);


            documentDB.setFilename(data[0]);
            documentDB.setDocfile(encodedtext);
            documentFileService.save(documentDB);
            System.out.println(new Gson().toJson(documentDB));

        }

        documentFileService.save(documentDB1);

        //http://localhost:8064/download/filename.txt
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFromDB/")
                .path(name)
                .toUriString();

        String contentType = file.getContentType();

        FileUploadResponse fileUploadResponse = new FileUploadResponse(name, contentType, url);

        return fileUploadResponse;
    }

//    @RequestMapping("/downloads/{file}")
//    ResponseEntity<Resource> downloadFilename(@PathVariable String FileName)
//    {
//        Resource resource=fileUploadService.downloadFile(FileName);
//        MediaType contentType= MediaType.APPLICATION_PDF;
//
//        return ResponseEntity.ok()
//                .contentType(contentType)
//                .header(HttpHeaders.CONTENT_DISPOSITION,"inline;FileName="+resource.getFilename() )
//                .body(resource);
//    }
//
//


}
