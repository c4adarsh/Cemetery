package com.ancestry.cemetery.Network;

import com.ancestry.cemetery.Presenter.Model.CemeteryList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by adarsh on 4/4/2017.
 */

public interface GetCemeteryService {

    @GET("api.cgi?mode=cemetery&cemeteryName=mead&limit=25&skip=0")
    Observable<CemeteryList> getCemeteryList();

}
