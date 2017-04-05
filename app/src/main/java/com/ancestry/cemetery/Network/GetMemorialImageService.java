package com.ancestry.cemetery.Network;

import com.ancestry.cemetery.Presenter.Model.MemorialList;
import com.ancestry.cemetery.Presenter.Model.MemorialPhotoList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by adarsh on 4/4/2017.
 */

public interface GetMemorialImageService {

    @GET("api.cgi?mode=memorialPhotos")
    Observable<MemorialPhotoList> getMemorialPhotoList(@Query("memorialId") String memorialId);

}
