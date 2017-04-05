package com.ancestry.cemetery;

import android.app.Application;

import com.ancestry.cemetery.Dagger.Component.DaggerNetComponent;
import com.ancestry.cemetery.Dagger.Component.NetComponent;
import com.ancestry.cemetery.Dagger.module.AppModule;
import com.ancestry.cemetery.Dagger.module.NetModule;

/**
 * Created by adarsh on 4/4/2017.
 */

public class CemeteryApplication extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://www.findagrave.com/cgi-bin/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
