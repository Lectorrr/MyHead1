package com.example.myhead.one.dto.resource;

import com.example.myhead.one.base.BaseDTO;

public class FilesDTO extends BaseDTO<String> {

    /**
     * 文件路径
     */
    private String fileRoad;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 错误信息路径
     */
    private String errorPath;

    /**
     * 状态
     */
    private String status;

    /**
     * 文件类型
     */
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
