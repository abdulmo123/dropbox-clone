package com.dbc_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AzureBlobDto {
    private String name;
    private AzureBlobFileProperties properties;
}
