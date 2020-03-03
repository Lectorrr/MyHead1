package com.example.myhead.one.entity.resource;

import com.example.myhead.one.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "resource_upload")
public class Upload extends BaseEntity<String> {

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
}
