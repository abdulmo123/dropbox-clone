package com.dbc_api.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AzureBlobStorageService {

    void uploadFile(MultipartFile file) throws IOException;
}
