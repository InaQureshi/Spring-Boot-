package io.c360.basefiletodb.Services;

import io.c360.basefiletodb.Entity.DocumentDB;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository

public interface DocumentFileService extends CrudRepository<DocumentDB,Long> {

}
