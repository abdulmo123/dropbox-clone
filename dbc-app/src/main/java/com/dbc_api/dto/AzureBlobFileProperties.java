package com.dbc_api.dto;

import com.azure.storage.blob.models.BlobType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AzureBlobFileProperties {
    private BlobType blobType;
    private Long contentLength;
    private OffsetDateTime creationTime;
}
