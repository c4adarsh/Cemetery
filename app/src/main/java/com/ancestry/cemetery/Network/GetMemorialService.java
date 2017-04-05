package com.ancestry.cemetery.Network;

import com.ancestry.cemetery.Presenter.Model.MemorialList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by adarsh on 4/4/2017.
 */

public interface GetMemorialService {

    @GET("api.cgi?mode=name&limit=25&skip=0&includeThumb=1")
    Observable<MemorialList> getMemorialList(@Query("cemeteryId") String cemeteryId);

}
