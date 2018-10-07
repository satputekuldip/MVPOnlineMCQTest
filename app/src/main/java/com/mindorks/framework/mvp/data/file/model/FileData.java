package com.mindorks.framework.mvp.data.file.model;

import com.google.gson.annotations.Expose;

import java.io.File;

/**
 * Created by SPARK on 24/06/2018.
 */
public class FileData {
    @Expose
    private File path;

    @Expose
    private String data;

    @Expose
    private String filename;

    public FileData(File path, String data, String filename) {
        this.path = path;
        this.data = data;
        this.filename = filename;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
