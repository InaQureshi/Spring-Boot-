package io.c360.encoding_decoding.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


import java.util.Arrays;

@Entity
@Table(name = "fileUpload")
public class UploadFile {

    @Id
    @Column(name = "fileID")
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String fileId;

    @Column(name = "filename")
    private  String filename;

    @Column(name = "fileType")
    private  String fileType;

    @Lob
    @Column(name = "fileData")
    private byte[] fileData;

    @Override
    public String toString() {
        return "UploadFile{" +
                "fileId='" + fileId + '\'' +
                ", filename='" + filename + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileData=" + Arrays.toString(fileData) +
                '}';
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public UploadFile(String fileId, String filename, String fileType, byte[] fileData) {
        this.fileId = fileId;
        this.filename = filename;
        this.fileType = fileType;
        this.fileData = fileData;
    }

    public UploadFile() {
    }
}
