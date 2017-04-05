package com.ancestry.cemetery.Model;

import com.ancestry.cemetery.Contract.MemorialPresenterContract;
import com.ancestry.cemetery.Network.GetCemeterySummaryService;
import com.ancestry.cemetery.Network.GetMemorialService;
import com.ancestry.cemetery.Presenter.Model.Cemetery;
import com.ancestry.cemetery.Presenter.Model.CemeteryList;
import com.ancestry.cemetery.Presenter.Model.CemeterySummary;
import com.ancestry.cemetery.Presenter.Model.MemorialList;

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

public class MemorialDataModel  implements MemorialPresenterContract.Model {

    Retrofit mRetrofit;

    MemorialPresenterContract.ModelCallBack mResponseCallBack;

    @Inject
    public MemorialDataModel(Retrofit mRetrofit){
        this.mRetrofit = mRetrofit;
    }

    @Override
    public void onAttach(MemorialPresenterContract.ModelCallBack mResponseCallBack) {
        this.mResponseCallBack = mResponseCallBack;
    }

    @Override
    public void onDetach() {
        mResponseCallBack = null;
    }

    public void loadUserDetails(String cemeteryId){
        Observable<MemorialList> observable = mRetrofit.create(GetMemorialService.class).getMemorialList(cemeteryId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MemorialList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MemorialList mMemorialList) {
                        mResponseCallBack.onResultLoad(mMemorialList.getMemorialList());
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

    public void loadCemeterySummary(String cemeteryId){
        Observable<CemeterySummary> observable = mRetrofit.create(GetCemeterySummaryService.class).getCemeteryList(cemeteryId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CemeterySummary>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CemeterySummary mCemeterySummary) {
                        mResponseCallBack.onResultCemeterySummary(mCemeterySummary.getCemetery());
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

