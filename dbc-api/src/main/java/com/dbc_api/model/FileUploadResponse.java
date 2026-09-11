package com.dbc_api.model;

import java.sql.Timestamp;

public record FileUploadResponse (
        String id,
        String filename,
        Long fileSize,
        String fileLocation,
        Timestamp uploadTimestamp
) {}
