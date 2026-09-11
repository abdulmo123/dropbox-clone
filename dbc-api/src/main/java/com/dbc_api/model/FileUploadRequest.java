package com.dbc_api.model;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

public record FileUploadRequest (
        MultipartFile file,
        Timestamp uploadTime
) {}