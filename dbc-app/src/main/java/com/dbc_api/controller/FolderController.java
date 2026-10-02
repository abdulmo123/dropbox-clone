package com.dbc_api.controller;

import com.dbc_api.service.FolderService;
import com.dbc_api.util.DbcResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbc_api.dto.FolderDto;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api/v1/folder")
@RestController
@CrossOrigin("http://127.0.0.1:5173")
@Slf4j
public class FolderController {

    private final FolderService folderService;
    private static final Logger LOGGER = LoggerFactory.getLogger(FolderController.class);

    FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @PostMapping("/create")
    public ResponseEntity<DbcResponse> createFolder(@RequestBody FolderDto folderDto) throws Exception {
        try {
            LOGGER.info("Folder {} created successfully...", folderDto);
            return ResponseEntity.ok(folderService.createFolder(folderDto));
        } catch (Exception e) {
            LOGGER.error("Error creating folder {}: {}", folderDto, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
