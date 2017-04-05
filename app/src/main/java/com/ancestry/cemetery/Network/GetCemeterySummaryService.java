package com.ancestry.cemetery.Network;

import com.ancestry.cemetery.Presenter.Model.CemeteryList;
import com.ancestry.cemetery.Presenter.Model.CemeterySummary;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by adarsh on 4/4/2017.
 */

public interface GetCemeterySummaryService {

    @GET("api.cgi?mode=cemeterySummary")
    Observable<CemeterySummary> getCemeteryList(@Query("cemeteryId") String cemeteryId);

}
