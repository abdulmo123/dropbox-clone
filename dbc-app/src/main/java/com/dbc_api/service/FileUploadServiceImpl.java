package com.dbc_api.service;

import com.dbc_api.model.FileUploadRequest;
import com.dbc_api.model.FileUploadResponse;
import com.dbc_api.repository.FileUploadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    private final FileUploadRepository fileUploadRepository;
    private final AzureBlobStorageService azureBlobStorageService;

    public FileUploadServiceImpl (FileUploadRepository fileUploadRepository, AzureBlobStorageService azureBlobStorageService) {
        this.fileUploadRepository = fileUploadRepository;
        this.azureBlobStorageService = azureBlobStorageService;
    }


    @Transactional
    @Override
    public FileUploadResponse uploadFile(FileUploadRequest fileUploadRequest, Timestamp timestamp) throws IOException {
        MultipartFile file = fileUploadRequest.file();
        String id = UUID.randomUUID().toString();


        // push it to Azure Blob storage ?
        azureBlobStorageService.uploadFile(file);

        // save the file info to DB
        fileUploadRepository.saveUploadFileInfo(
                id,
                file.getOriginalFilename(),
                file.getSize(),
                ""
        );

        return new FileUploadResponse(id, file.getOriginalFilename(), file.getSize(), "", timestamp);
    }
}
