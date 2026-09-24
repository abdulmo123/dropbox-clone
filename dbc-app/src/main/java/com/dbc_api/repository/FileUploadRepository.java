package com.dbc_api.repository;

import com.dbc_api.dto.FileDto;
import com.dbc_api.model.entity.FileUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUploadEntity, String> {

        // query to insert data
        @Modifying
        @Query(value = """
                        INSERT INTO dbc.file_upload (id, file_name, file_size, file_location, upload_timestamp)
                        VALUES (:id, :fileName, :fileSize, :fileLocation, CURRENT_TIMESTAMP)
                        """, nativeQuery = true)
        void saveUploadFileInfo(@Param("id") String id,
                        @Param("fileName") String fileName,
                        @Param("fileSize") Long fileSize,
                        @Param("fileLocation") String fileLocation);

        @Query(value = """
                        select fu.id, fu.file_name
                        from dbc.file_upload fu
                        where fu.file_name = :fileName
                        """, nativeQuery = true)
        FileDto checkFileExists(@Param("fileName") String filename);

        @Modifying
        @Query(value = """
                        update dbc.file_upload
                        set upload_timestamp = CURRENT_TIMESTAMP
                        where file_name = :fileName
                        """, nativeQuery = true)
        void updateUploadFileInfo(@Param("fileName") String fileName);
}
