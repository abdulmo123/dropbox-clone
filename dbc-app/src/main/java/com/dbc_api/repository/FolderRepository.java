package com.dbc_api.repository;

import com.dbc_api.model.entity.FolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<FolderEntity, String> {

        @Query(value = """
                        insert into dbc.folder (id, folder_name)
                        values(:id, :folderName)
                        returning *
                        """, nativeQuery = true)

        FolderEntity createFolder(@Param("id") String id,
                        @Param("folderName") String folderName);

        @Query(value = """
                        select exists(select 1 from dbc.folder where folder_name = :folderName)
                        """, nativeQuery = true)
        boolean folderNameExists(@Param("folderName") String folderName);
}
