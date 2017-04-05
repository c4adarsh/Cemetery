package com.ancestry.cemetery.Dagger.module;

import com.ancestry.cemetery.Dagger.Scope.ActivityScope;
import com.ancestry.cemetery.Dagger.Scope.MemorialActivityScope;
import com.ancestry.cemetery.Model.CemeteryDataModel;
import com.ancestry.cemetery.Model.MemorialDataModel;
import com.ancestry.cemetery.Presenter.MainPresenter;
import com.ancestry.cemetery.Presenter.MemorialPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by adarsh on 4/4/2017.
 */

@Module
public class MemorialActivityModule {


    public MemorialActivityModule(){
    }

    @Provides
    @MemorialActivityScope
    MemorialPresenter provideMemorialPresenter(MemorialDataModel mModel) {
        return new MemorialPresenter(mModel);
    }
    @Provides
    @MemorialActivityScope
    MemorialDataModel provideDataFetchModel(Retrofit mRetrofit){
        return new MemorialDataModel(mRetrofit);
    }
}

