package com.dbc_api.controller;

import com.dbc_api.dto.AzureBlobDto;
import com.dbc_api.service.AzureBlobStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/azure-blob")
@RestController
public class AzureBlobStorageController {

    private final AzureBlobStorageService azureBlobStorageService;

    public AzureBlobStorageController(AzureBlobStorageService azureBlobStorageService) {
        this.azureBlobStorageService = azureBlobStorageService;
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<AzureBlobDto>> getAllBlobs() {
         return ResponseEntity.ok(azureBlobStorageService.getAllFiles());
    }
}
