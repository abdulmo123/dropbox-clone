package com.dbc_api.service;

import com.dbc_api.model.FileUploadRequest;
import com.dbc_api.model.FileUploadResponse;

import java.io.IOException;
import java.sql.Timestamp;

public interface FileUploadService {

    FileUploadResponse uploadFile(FileUploadRequest fileUploadRequest, Timestamp timestamp) throws IOException;
}
