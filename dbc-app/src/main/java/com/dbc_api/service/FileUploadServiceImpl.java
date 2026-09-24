package com.dbc_api.service;

import com.dbc_api.dto.FileDto;
import com.dbc_api.model.FileUploadRequest;
import com.dbc_api.model.FileUploadResponse;
import com.dbc_api.repository.FileUploadRepository;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    @Value("${spring.cloud.azure.storage.container.name}")
    private String azureContainerName;

    private final FileUploadRepository fileUploadRepository;
    private final AzureBlobStorageService azureBlobStorageService;

    public FileUploadServiceImpl(FileUploadRepository fileUploadRepository,
            AzureBlobStorageService azureBlobStorageService) {
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

        FileDto fileDto = new FileDto();
        fileDto = fileUploadRepository.checkFileExists(file.getOriginalFilename());

        if (fileDto != null) {
            // update the file info in DB
            LOGGER.info("File {} already exists...", fileDto.getFileName());
            fileUploadRepository.updateUploadFileInfo(fileDto.getFileName());
        } else {
            // save the file info to DB
            LOGGER.info("Uploading new file: {}", file.getOriginalFilename());
            fileUploadRepository.saveUploadFileInfo(
                    id,
                    file.getOriginalFilename(),
                    file.getSize(),
                    azureContainerName + "/" + file.getOriginalFilename());
        }

        return new FileUploadResponse(id, file.getOriginalFilename(), file.getSize(), "", timestamp);
    }
}
