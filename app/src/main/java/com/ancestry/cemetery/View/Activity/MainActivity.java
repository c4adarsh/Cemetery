package com.ancestry.cemetery.View.Activity;

import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.ancestry.cemetery.CemeteryApplication;
import com.ancestry.cemetery.Contract.MainPresenterContract;
import com.ancestry.cemetery.Dagger.Component.DaggerMainActivityComponent;
import com.ancestry.cemetery.Dagger.Component.MainActivityComponent;
import com.ancestry.cemetery.Dagger.module.MainActivityModule;
import com.ancestry.cemetery.Presenter.MainPresenter;
import com.ancestry.cemetery.Presenter.Model.Cemetery;
import com.ancestry.cemetery.R;
import com.ancestry.cemetery.Utils.Constants;
import com.ancestry.cemetery.databinding.ActivityMainBinding;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainPresenterContract.View{

    @Inject
    MainPresenter mainPresenter;

    MainActivityComponent mMainActivityComponent;

    GoogleMap mMap;

    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    private static final String TAG = "MainActivity";

   //GoogleApiClient mGoogleApiClient;

    List<Marker> mMarkers = new ArrayList<Marker>();;

    MarkerOptions mMarkerOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule())
                .netComponent(((CemeteryApplication)getApplicationContext()).getNetComponent())
                .build();
        mMainActivityComponent.inject(this);

        attachPresenterCallBack();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setUpToolBar();

        initMap();

        if(savedInstanceState!=null){
            restoreUI(savedInstanceState);
        }
    }

    private void attachPresenterCallBack() {
        if(mainPresenter!=null){
            mainPresenter.attach(this);
        }
    }

    private void setUpToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.ic_ac_unit_black_24dp);
        getSupportActionBar().setIcon(drawable);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("  " + getString(R.string.app_name));
    }

    private void restoreUI(Bundle savedInstanceState) {
        String mStoredValue = savedInstanceState.getString("Adarsh");
        if(mStoredValue!=null){
            //Log.i("Dude",mStoredValue);
        }else{
            //Log.i("Dude","null");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putString("Adarsh","Iam Adarsh");
    }

    private void initMap() {
        SupportMapFragment mSupportMapFragment = (SupportMapFragment)getSupportFragmentManager().
                findFragmentById(R.id.map);
        if(mSupportMapFragment==null){
            Toast.makeText(this,"mSupportMapFragment is null",Toast.LENGTH_LONG).show();
            return;
        }
        mSupportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                mainPresenter.load();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void addResults(List<Cemetery> mCemeteryList) {

        for(Cemetery cementry : mCemeteryList){
            if(cementry.getLatitude()!=null && cementry.getLongitude()!=null &&
                    cementry.getLongitude().length()!=0 && cementry.getLatitude().length()!=0){

                LatLng mLocation = new LatLng(Double.valueOf(cementry.getLatitude()),
                        Double.valueOf(cementry.getLongitude()));

                MarkerOptions markerOptions = new MarkerOptions();

                String city = "";

                if(cementry.getCityName()!=null && cementry.getCityName().length()>0){
                    city = cementry.getCityName();
                }else{
                    if(cementry.getStateName()!=null){
                        city = cementry.getStateName();
                    }
                }

                markerOptions.position(mLocation)
                        .title(city);

                if(cementry.getCountryName()!=null && cementry.getCountryName().length()>0){
                    markerOptions.snippet(cementry.getCountryName());
                }

                Marker mMarker;

                mMarker = mMap.addMarker(markerOptions);
                mMarker.setTag(cementry.getCemeteryId());

                mMarkers.add(mMarker);

                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        String tag = String.valueOf(marker.getTag());
                        Intent mIntent = new Intent(MainActivity.this,MemorialActivity.class);
                        mIntent.putExtra(Constants.ID,tag);
                        startActivity(mIntent);
                        return false;
                    }
                });
            }
        }

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Marker marker : mMarkers) {
            builder.include(marker.getPosition());
        }
        LatLngBounds bounds = builder.build();
        int padding = 50; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        mMap.animateCamera(cu);

    }

    @Override
    public void clearResults() {

    }

    @Override
    public void showContentLoading() {

    }

    @Override
    public void hideContentLoading() {

    }

    @Override
    public void showListLoading() {

    }

    @Override
    public void hideListLoading() {

    }

    @Override
    public void showContentError() {

    }

    @Override
    public void hideContentError() {

    }

    @Override
    public void showListError() {

    }

    @Override
    public void showEmptyResultsView() {

    }

    @Override
    public void hideEmptyResultsView() {

    }
}
