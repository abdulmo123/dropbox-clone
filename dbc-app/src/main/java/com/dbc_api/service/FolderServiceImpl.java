package com.dbc_api.service;

import com.dbc_api.dto.FolderDto;
import com.dbc_api.model.entity.FolderEntity;
import com.dbc_api.repository.FolderRepository;
import com.dbc_api.util.DbcResponse;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class FolderServiceImpl implements FolderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FolderServiceImpl.class);

    private final FolderRepository folderRepository;

    public FolderServiceImpl(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    @Override
    public DbcResponse createFolder(FolderDto folderDto) {
        String folderName = folderDto.getFolderName();
        try {

            if (folderRepository.folderNameExists(folderName)) {
                LOGGER.error("Folder {} already exists...", folderName);
                return DbcResponse.builder()
                        .message("Folder already exists")
                        .data(null)
                        .statusCode(409)
                        .build();
            }

            String id = UUID.randomUUID().toString();
            FolderEntity folderEntity = folderRepository.createFolder(id, folderName);
            LOGGER.info("Folder {} created successfully...", folderName);
            return DbcResponse.builder()
                    .message("Folder created successfully")
                    .data(folderEntity)
                    .statusCode(201)
                    .build();
        } catch (Exception e) {
            LOGGER.error("Error creating folder {}: {}", folderName, e.getMessage());
            return DbcResponse.builder()
                    .message(e.getMessage())
                    .data(null)
                    .statusCode(500)
                    .build();
        }
    }
}
