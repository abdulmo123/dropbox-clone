package com.dbc_api.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobItem;
import com.dbc_api.dto.AzureBlobDto;
import com.dbc_api.dto.AzureBlobFileProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AzureBlobStorageServiceImpl implements AzureBlobStorageService {

    private final BlobContainerClient blobContainerClient;

    public AzureBlobStorageServiceImpl(BlobContainerClient blobContainerClient) {
        this.blobContainerClient = blobContainerClient;
    }

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        String blobName = file.getOriginalFilename();
        if (blobName == null || !blobName.isEmpty()) {
            return;
        }

        BlobClient blobClient = blobContainerClient.getBlobClient(blobName);
        blobClient.upload(file.getInputStream(), file.getSize(), true);
    }

    @Override
    public List<AzureBlobDto> getAllFiles() {
        List<AzureBlobDto> azureBlobDtoList = new ArrayList<>();
        for (BlobItem blobItem : blobContainerClient.listBlobs()) {
            AzureBlobDto azureBlobDto = new AzureBlobDto();
            azureBlobDto.setName(blobItem.getName());

            AzureBlobFileProperties azureBlobFileProperties = new AzureBlobFileProperties();
            azureBlobFileProperties.setBlobType(blobItem.getProperties().getBlobType());
            azureBlobFileProperties.setContentLength(blobItem.getProperties().getContentLength());
            azureBlobFileProperties.setCreationTime(blobItem.getProperties().getCreationTime());

            azureBlobDto.setProperties(azureBlobFileProperties);

            azureBlobDtoList.add(azureBlobDto);
        }

        return azureBlobDtoList;
    }
}
