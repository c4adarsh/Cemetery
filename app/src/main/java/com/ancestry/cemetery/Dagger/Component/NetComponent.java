package com.ancestry.cemetery.Dagger.Component;

import android.content.SharedPreferences;

import com.ancestry.cemetery.Dagger.module.AppModule;
import com.ancestry.cemetery.Dagger.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by adarsh on 4/4/2017.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();
}
