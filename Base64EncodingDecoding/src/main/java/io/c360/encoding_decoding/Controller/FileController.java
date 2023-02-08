package io.c360.encoding_decoding.Controller;

import io.c360.encoding_decoding.Services.FileServices;
import io.c360.encoding_decoding.entity.UploadFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController("/base64")
@RequestMapping()
public class FileController {

    public FileServices fileServices;

    @PostMapping("/uploadtoDB")
    public void UploadtoDB(@RequestParam("file") UploadFile file) {
        fileServices.FileUploadtoDB(file);

    }

}
