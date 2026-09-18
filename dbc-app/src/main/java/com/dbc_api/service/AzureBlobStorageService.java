package com.dbc_api.service;

import com.dbc_api.dto.AzureBlobDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AzureBlobStorageService {

    void uploadFile(MultipartFile file) throws IOException;

    List<AzureBlobDto> getAllFiles();
}
