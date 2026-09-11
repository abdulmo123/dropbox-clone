package com.dbc_api.controller;

import com.dbc_api.model.FileUploadRequest;
import com.dbc_api.model.FileUploadResponse;
import com.dbc_api.service.FileUploadService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@RequestMapping("/api/v1/file")
@RestController
public class FileUploadController {

    private final FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file") MultipartFile file) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        FileUploadRequest fileUploadRequest = new FileUploadRequest(file, timestamp);
        return ResponseEntity.ok(fileUploadService.uploadFile(fileUploadRequest, timestamp));
    }
}
