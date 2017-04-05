package com.ancestry.cemetery.Presenter.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by adarsh on 4/4/2017.
 */

public class MemorialList {

    @SerializedName("memorial")
    private List<Memorial> memorialList;

    public MemorialList(List<Memorial> memorialList) {
        this.memorialList = memorialList;
    }

    public List<Memorial> getMemorialList() {
        return memorialList;
    }
}
