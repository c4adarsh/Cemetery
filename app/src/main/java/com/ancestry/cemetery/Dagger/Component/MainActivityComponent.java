package com.ancestry.cemetery.Dagger.Component;

import com.ancestry.cemetery.Dagger.Scope.ActivityScope;
import com.ancestry.cemetery.Dagger.module.MainActivityModule;
import com.ancestry.cemetery.View.Activity.MainActivity;

import dagger.Component;

/**
 * Created by adarsh on 4/3/2017.
 */

@ActivityScope
@Component(dependencies = NetComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
