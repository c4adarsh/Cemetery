package com.ancestry.cemetery.Dagger.module;

import com.ancestry.cemetery.Dagger.Scope.ActivityScope;
import com.ancestry.cemetery.Model.CemeteryDataModel;
import com.ancestry.cemetery.Presenter.MainPresenter;


import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by adarsh on 4/4/2017.
 */

@Module
public class MainActivityModule {


    public MainActivityModule(){
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(CemeteryDataModel mModel) {
        return new MainPresenter(mModel);
    }
    @Provides
    @ActivityScope
    CemeteryDataModel provideDataFetchModel(Retrofit mRetrofit){
        return new CemeteryDataModel(mRetrofit);
    }
}

