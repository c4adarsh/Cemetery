package com.ancestry.cemetery.Dagger.Component;

import com.ancestry.cemetery.Dagger.Scope.ActivityScope;
import com.ancestry.cemetery.Dagger.Scope.MemorialActivityScope;
import com.ancestry.cemetery.Dagger.module.MainActivityModule;
import com.ancestry.cemetery.Dagger.module.MemorialActivityModule;
import com.ancestry.cemetery.View.Activity.MainActivity;
import com.ancestry.cemetery.View.Activity.MemorialActivity;

import dagger.Component;

/**
 * Created by adarsh on 4/4/2017.
 */

@MemorialActivityScope
@Component(dependencies = NetComponent.class, modules = MemorialActivityModule.class)
public interface MemorialActivityComponent {
    void inject(MemorialActivity activity);
}
