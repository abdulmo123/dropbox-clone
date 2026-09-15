package com.dbc_api.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AzureBlobStorageServiceImpl implements AzureBlobStorageService {

    private final BlobContainerClient blobContainerClient;

    public AzureBlobStorageServiceImpl(BlobContainerClient blobContainerClient) {
        this.blobContainerClient = blobContainerClient;
    }

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        String blobName = file.getOriginalFilename();
        BlobClient blobClient = blobContainerClient.getBlobClient(blobName);

        blobClient.upload(file.getInputStream(), file.getSize(), true);
    }
}
