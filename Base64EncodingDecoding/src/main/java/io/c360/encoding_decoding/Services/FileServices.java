package io.c360.encoding_decoding.Services;

import io.c360.encoding_decoding.FileRepository.fileUploadRepository;
import io.c360.encoding_decoding.entity.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

public class  FileServices {

    @Autowired
    public fileUploadRepository fileUploadRepository;

    public String uploadFolderpath="C:\\Users\\DELL\\Desktop\\uploaded_";

    public void FileUploadtoDB(UploadFile file){
        byte[] data = Base64.getEncoder().encode(uploadFolderpath.getBytes(StandardCharsets.UTF_8));


        UploadFile uploadFile=new UploadFile();
        uploadFile.setFileData(new byte[]{data[0]});
        uploadFile.setFilename("Nameof File");
        uploadFile.setFileType("URL File");
        fileUploadRepository.save(uploadFile);
        }


}
