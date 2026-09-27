package com.dbc_api.model.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "folder", schema = "dbc")
@Data
public class FolderEntity {

    @Id
    private String id;

    @Basic
    @Column(name = "folder_name")
    private String folderName;

}
