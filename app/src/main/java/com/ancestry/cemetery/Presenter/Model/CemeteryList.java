package com.ancestry.cemetery.Presenter.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by adarsh on 4/4/2017.
 */

public class CemeteryList {

    @SerializedName("cemetery")
    private List<Cemetery> CemeteryList;

    public CemeteryList(List<Cemetery> cemeteryList) {
        this.CemeteryList = cemeteryList;
    }

    public List<Cemetery> getCemeteryList() {
        return CemeteryList;
    }

}
