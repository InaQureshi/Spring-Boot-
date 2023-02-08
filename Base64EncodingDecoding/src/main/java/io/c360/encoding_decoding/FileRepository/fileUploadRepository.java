package io.c360.encoding_decoding.FileRepository;

import io.c360.encoding_decoding.entity.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fileUploadRepository extends JpaRepository<UploadFile,String> {
}
