package com.ancestry.cemetery.Model;

import android.util.Log;

import com.ancestry.cemetery.Contract.MainPresenterContract;
import com.ancestry.cemetery.Network.GetCemeteryService;
import com.ancestry.cemetery.Presenter.Model.Cemetery;
import com.ancestry.cemetery.Presenter.Model.CemeteryList;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by adarsh on 4/4/2017.
 */

public class CemeteryDataModel implements MainPresenterContract.Model {

    Retrofit mRetrofit;

    MainPresenterContract.ModelCallBack mResponseCallBack;

    @Inject
    public CemeteryDataModel(Retrofit mRetrofit){
        this.mRetrofit = mRetrofit;
    }

    @Override
    public void onAttach(MainPresenterContract.ModelCallBack mResponseCallBack) {
        this.mResponseCallBack = mResponseCallBack;
    }

    @Override
    public void onDetach() {
        mResponseCallBack = null;
    }

    public void loadUserDetails(String mName){
        Observable<CemeteryList> observable = mRetrofit.create(GetCemeteryService.class).getCemeteryList(mName);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CemeteryList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CemeteryList mCemetryList) {
                        mResponseCallBack.onResultLoad(mCemetryList.getCemeteryList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mResponseCallBack.onErrorLoad(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
