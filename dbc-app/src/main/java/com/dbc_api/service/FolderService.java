package com.dbc_api.service;

import com.dbc_api.dto.FolderDto;
import com.dbc_api.util.DbcResponse;

public interface FolderService {

    DbcResponse createFolder(FolderDto folderDto);
}
