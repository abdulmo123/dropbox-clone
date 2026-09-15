package com.dbc_api.model.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "file_upload", schema = "dbc")
public class FileUploadEntity {

    @Id
    private String id;

//    private Long userId;

    @Basic
    @Column(name = "file_name")
    private String filename;

    @Basic
    @Column(name = "file_size")
    private Long fileSize;

    @Basic
    @Column(name = "file_location")
    private String fileLocation;

    @Basic
    @Column(name = "upload_timestamp")
    private Timestamp uploadTimestamp;
}
