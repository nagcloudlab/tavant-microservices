package com.example.instamediaservice.payload;

public class UploadFileResponse {

    private String fileName;
    private String uri;
    private String fileType;

    public UploadFileResponse(String fileName, String uri, String fileType) {
        this.fileName = fileName;
        this.uri = uri;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
