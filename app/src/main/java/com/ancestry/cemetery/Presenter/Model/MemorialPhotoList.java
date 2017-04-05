package com.ancestry.cemetery.Presenter.Model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by adarsh on 4/4/2017.
 */

public class MemorialPhotoList {

    @SerializedName("memorialPhotos")
    private List<MemorialPhoto> memorialPhotoList;

    public List<MemorialPhoto> getMemorialPhotoList() {
        return memorialPhotoList;
    }

    public void setMemorialPhotoList(List<MemorialPhoto> memorialPhotoList) {
        this.memorialPhotoList = memorialPhotoList;
    }
}

