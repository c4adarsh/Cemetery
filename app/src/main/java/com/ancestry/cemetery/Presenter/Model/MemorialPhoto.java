package com.ancestry.cemetery.Presenter.Model;

/**
 * Created by adarsh on 4/5/2017.
 */

public class MemorialPhoto {

    String fileName;

    public MemorialPhoto(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
