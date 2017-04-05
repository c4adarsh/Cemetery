package com.ancestry.cemetery.Presenter.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by adarsh on 4/4/2017.
 */

public class CemeterySummary {

    @SerializedName("cemeterySummary")
    private Cemetery cemetery;

    public Cemetery getCemetery() {
        return cemetery;
    }

    public void setCemetery(Cemetery cemetery) {
        this.cemetery = cemetery;
    }
}
