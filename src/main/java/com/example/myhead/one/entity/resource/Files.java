package com.example.myhead.one.entity.resource;

import com.example.myhead.one.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "resource_files")
public class Files extends BaseEntity<String> {

    /**
     * 文件路径
     */
    @Column(name = "file_path")
    private String fileRoad;

    /**
     * 文件名
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 错误信息路径
     */
    @Column(name = "error_path")
    private String errorPath;

    /**
     * 状态
     */
    @Column(name = "status")
    private String status;

    /**
     * 文件类型
     */
    @Column(name = "file_type")
    private String fileType;

//    /**
//     * 文件类型
//     */
//    @ManyToOne
//    @JoinColumn(name = "file_type_id", referencedColumnName = "UUID")
//    private FilesType filesType;

    public String getFileRoad() {
        return fileRoad;
    }

    public void setFileRoad(String fileRoad) {
        this.fileRoad = fileRoad;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getErrorPath() {
        return errorPath;
    }

    public void setErrorPath(String errorPath) {
        this.errorPath = errorPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
