package io.c360.basefiletodb.Entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class DocumentDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String filename;
    @Lob
    private String docfile;

    public DocumentDB() {
    }

    @Override
    public String toString() {
        return "DocumentDB{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", docfile='" + docfile + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDocfile() {
        return docfile;
    }

    public void setDocfile(String docfile) {
        this.docfile = docfile;
    }

    public DocumentDB(long id, String filename, String docfile) {
        this.id = id;
        this.filename = filename;
        this.docfile = docfile;
    }
}
