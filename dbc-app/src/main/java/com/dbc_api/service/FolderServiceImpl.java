package com.dbc_api.service;

import com.dbc_api.dto.FolderDto;
import com.dbc_api.model.entity.FolderEntity;
import com.dbc_api.repository.FolderRepository;
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
    public FolderDto createFolder(FolderDto folderDto) {
        // TODO: add validation for folder name ... can't have duplicate folder names
        String folderName = folderDto.getFolderName();
        try {
            String id = UUID.randomUUID().toString();
            FolderEntity folderEntity = folderRepository.createFolder(id, folderName);
            LOGGER.info("Folder {} created successfully...", folderName);
            return FolderDto.builder()
                    .id(folderEntity.getId())
                    .folderName(folderEntity.getFolderName())
                    .build();
        } catch (Exception e) {
            LOGGER.error("Error creating folder {}: {}", folderName, e.getMessage());
            throw new RuntimeException("Unable to create folder ...");
        }
    }
}
