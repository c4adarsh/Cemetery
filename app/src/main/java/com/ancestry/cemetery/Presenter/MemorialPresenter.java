package com.ancestry.cemetery.Presenter;

import android.util.Log;

import com.ancestry.cemetery.Contract.MainPresenterContract;
import com.ancestry.cemetery.Contract.MemorialPresenterContract;
import com.ancestry.cemetery.Model.CemeteryDataModel;
import com.ancestry.cemetery.Model.MemorialDataModel;
import com.ancestry.cemetery.Presenter.Model.Cemetery;
import com.ancestry.cemetery.Presenter.Model.Memorial;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by adarsh on 4/4/2017.
 */

public class MemorialPresenter implements MemorialPresenterContract.Presenter, MemorialPresenterContract.ModelCallBack {

    MemorialPresenterContract.View mMainView = null;

    MemorialDataModel model;

    String CemeteryId;


    @Inject
    public MemorialPresenter(MemorialDataModel pDataModel) {
        model = pDataModel;
        model.onAttach(this);
    }

    @Override
    public void attach(MemorialPresenterContract.View view) {
        mMainView = view;
    }

    @Override
    public void detach() {
        mMainView = null;
    }


    @Override
    public void load(String mCemetryId) {
        this.CemeteryId = mCemetryId;
        if (mMainView != null) {
            model.loadUserDetails(mCemetryId);
        } else {
            Log.d("MemorialPresenter", "mMainView is null");
        }
    }

    @Override
    public void loadMore(String mCemetryId) {
        if (mMainView != null) {

        }
    }

    @Override
    public void queryChanged(String query) {
        if (mMainView != null) {

        }
    }

    @Override
    public void listItemClicked(Memorial memorial) {
        if (mMainView != null) {

        }
    }

    @Override
    public void loadCemeterySummary(String cemeteryId) {
        if (mMainView != null) {
            model.loadCemeterySummary(cemeteryId);
        } else {
            Log.d("MemorialPresenter", "mMainView is null");
        }
    }

    //These are the main model call backs

    @Override
    public void onResultLoadMore(List<Memorial> mMemorial) {
        if (mMainView != null) {
            mMainView.addResults(mMemorial);
        }
    }

    @Override
    public void onResultLoad(List<Memorial> memorialList) {
        if (mMainView != null) {
            if (memorialList.size() == 0) {
                mMainView.showEmptyResultsView();
            } else {
                mMainView.clearResults();
                mMainView.addResults(memorialList);
            }
        } else {
            Log.d("MemorialPresenter", "onResultLoad is null");
        }
    }

    @Override
    public void onErrorLoad(String mErrorMessage) {
        if (mMainView != null) {
            mMainView.showContentError();
        }
    }

    @Override
    public void onErrorLoadMore(String mErrorMessage) {
        if (mMainView != null) {
            mMainView.showContentError();
        }
    }

    @Override
    public void onResultCemeterySummary(Cemetery mCemetery) {
        if (mMainView != null) {
            mMainView.showCemeterySummary(mCemetery);
        }
    }

}
