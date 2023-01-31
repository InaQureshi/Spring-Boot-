package io.c360.basefiletodb.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService {


    private Path fileStoragepath;

    private String filelocationStorage;

    public FileUploadService(@Value("${file.storage.location:temp}")String filelocationStorage ) {
        this.filelocationStorage=filelocationStorage;
        fileStoragepath= Paths.get(filelocationStorage).toAbsolutePath().normalize();
        try {
            Files.createDirectories(fileStoragepath);
        } catch (IOException e) {
            throw new RuntimeException("Issue Creating in Creating File!!!!",e);
        }


    }


    public String storeFile(MultipartFile file) {
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        Path filePath = Paths.get(fileStoragepath+ "\\" + fileName);

        try {
            Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Issue In Reading File !!!1",e);
        }

        return fileName;
    }

    public Resource downloadFile(String fileName) {
       Path path= Paths.get(filelocationStorage).toAbsolutePath().resolve(fileName);
       Resource resource;

        try {
             resource=new UrlResource(path.toUri());
            return resource;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Issue in Reading File !!!!",e);
        }

//        if(resource.exists() && resource.isReadable())
//        {
//            return resource;
//
//        }else {
//            throw  new RuntimeException("File is not EXIST or not READABLE !!!");
//        }
    }
}
