package com.ancestry.cemetery.Presenter;

import android.os.Bundle;

/**
 * Created by adarsh on 4/3/2017.
 */

public interface BasePresenterInterface<V> {
    void attach(V view);
    void detach();
    /*void saveState(Bundle mBundle);
    Bundle restoreState();*/
}
