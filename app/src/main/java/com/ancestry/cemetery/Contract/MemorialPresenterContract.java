package com.ancestry.cemetery.Contract;

import com.ancestry.cemetery.Presenter.BasePresenterInterface;
import com.ancestry.cemetery.Presenter.Model.Cemetery;
import com.ancestry.cemetery.Presenter.Model.Memorial;

import java.util.List;

/**
 * Created by adarsh on 4/4/2017.
 */

public class MemorialPresenterContract {

    public interface View {
        void addResults(List<Memorial> memorialList);
        void clearResults();
        void showContentLoading();
        void hideContentLoading();
        void showListLoading();
        void hideListLoading();
        void showContentError();
        void hideContentError();
        void showListError();
        void showEmptyResultsView();
        void hideEmptyResultsView();
        void showCemeterySummary(Cemetery mCemetery);
    }
    public interface Presenter extends BasePresenterInterface<View> {
        void load(String cemeteryId);
        void loadMore(String cemeteryId);
        void queryChanged(String query);
        void listItemClicked(Memorial memorial);
        void loadCemeterySummary(String cemeteryId);
    }
    public interface Model{
       void onAttach(MemorialPresenterContract.ModelCallBack mResponseCallBack);
       void onDetach();
    }
    public interface ModelCallBack{
        void onResultLoad(List<Memorial> memorialList);
        void onResultLoadMore(List<Memorial> memorialList);
        void onErrorLoad(String mErrorMessage);
        void onErrorLoadMore(String mErrorMessage);
        void onResultCemeterySummary(Cemetery mCemetery);
    }

}
