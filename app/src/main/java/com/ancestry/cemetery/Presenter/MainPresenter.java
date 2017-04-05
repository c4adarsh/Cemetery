package com.ancestry.cemetery.Presenter;

import android.os.Bundle;
import android.util.Log;

import com.ancestry.cemetery.Contract.MainPresenterContract;
import com.ancestry.cemetery.Model.CemeteryDataModel;
import com.ancestry.cemetery.Presenter.Model.Cemetery;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by adarsh on 4/4/2017.
 */

public class MainPresenter implements MainPresenterContract.Presenter, MainPresenterContract.ModelCallBack{

    MainPresenterContract.View mMainView = null;

    CemeteryDataModel model;


    @Inject
    public MainPresenter(CemeteryDataModel pDataModel) {
        model = pDataModel;
        model.onAttach(this);
    }

    @Override
    public void attach(MainPresenterContract.View view) {
        mMainView = view;
    }

    @Override
    public void detach() {
        mMainView = null;
    }


    @Override
    public void load(String mName) {
        if(mMainView!=null){
            model.loadUserDetails(mName);
        }else{
            Log.i("Adarsh","mMainView is null");
        }
    }

    @Override
    public void loadMore() {
        if(mMainView!=null){

        }
    }

    @Override
    public void queryChanged(String query) {
        if(mMainView!=null){

        }
    }

    @Override
    public void listItemClicked(Cemetery cemetery) {
        if(mMainView!=null){

        }
    }

    //These are the main model call backs

    @Override
    public void onResultLoadMore(List<Cemetery> mCemetery) {
        if(mMainView!=null){
            mMainView.addResults(mCemetery);
        }
    }

    @Override
    public void onResultLoad(List<Cemetery> cemeteryList) {
        if(mMainView!=null){
            Log.i("Adarsh","I am here1 dude");
            if(cemeteryList==null || cemeteryList.size()==0){
                mMainView.showEmptyResultsView();
            }else{
                mMainView.clearResults();
                mMainView.addResults(cemeteryList);
            }
        }else{
            Log.i("Adarsh","I am here dude");
        }
    }

    @Override
    public void onErrorLoad(String mErrorMessage) {
        if(mMainView!=null){
            mMainView.showEmptyResultsView();
        }
    }

    @Override
    public void onErrorLoadMore(String mErrorMessage) {
        if(mMainView!=null){
            mMainView.showEmptyResultsView();
        }
    }
}
