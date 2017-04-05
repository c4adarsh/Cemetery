package com.ancestry.cemetery.Contract;

import com.ancestry.cemetery.Presenter.BasePresenterInterface;
import com.ancestry.cemetery.Presenter.Model.Cemetery;


import java.util.List;

/**
 * Created by adarsh on 4/4/2017.
 */

public class MainPresenterContract {

    public interface View {
        void addResults(List<Cemetery> cemeteryList);
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
    }
    public interface Presenter extends BasePresenterInterface<View> {
        void load(String mName);
        void loadMore();
        void queryChanged(String query);
        void listItemClicked(Cemetery cemetery);
    }
    public interface Model{
       void onAttach(MainPresenterContract.ModelCallBack mResponseCallBack);
       void onDetach();
    }
    public interface ModelCallBack{
        void onResultLoad(List<Cemetery> cemeteryList);
        void onResultLoadMore(List<Cemetery> cemeteryList);
        void onErrorLoad(String mErrorMessage);
        void onErrorLoadMore(String mErrorMessage);
    }

}
