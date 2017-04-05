package com.ancestry.cemetery.View.Activity;

import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ancestry.cemetery.CemeteryApplication;
import com.ancestry.cemetery.Contract.MemorialPresenterContract;
import com.ancestry.cemetery.Dagger.Component.DaggerMemorialActivityComponent;
import com.ancestry.cemetery.Dagger.Component.MemorialActivityComponent;
import com.ancestry.cemetery.Dagger.module.MemorialActivityModule;
import com.ancestry.cemetery.Presenter.MemorialPresenter;
import com.ancestry.cemetery.Presenter.Model.Cemetery;
import com.ancestry.cemetery.Presenter.Model.Memorial;
import com.ancestry.cemetery.R;
import com.ancestry.cemetery.Utils.Constants;
import com.ancestry.cemetery.View.Adapter.OnItemClickListener;
import com.ancestry.cemetery.View.Adapter.RecyclerViewAdapter;
import com.ancestry.cemetery.databinding.ActivityMemorialBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.ancestry.cemetery.Utils.Constants.MEMORIAL_ITEM;

/**
 * Created by adarsh on 4/4/2017.
 */

public class MemorialActivity extends AppCompatActivity implements MemorialPresenterContract.View {

    @Inject
    MemorialPresenter memorialPresenter;

    MemorialActivityComponent mMemorialActivityComponent;

    ActivityMemorialBinding binding;

    private List<Memorial> memorialList = new ArrayList<Memorial>();

    private RecyclerView mRecyclerView;

    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMemorialActivityComponent = DaggerMemorialActivityComponent.builder()
                .memorialActivityModule(new MemorialActivityModule())
                .netComponent(((CemeteryApplication)getApplicationContext()).getNetComponent())
                .build();
        mMemorialActivityComponent.inject(this);

        attachPresenterCallBack();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_memorial);
        setUpToolBar();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(MemorialActivity.this, memorialList );
        binding.recyclerView.setAdapter(adapter);

        onClickListener();

        String cemeteryId = getIntent().getStringExtra(Constants.ID);
        if(memorialPresenter!=null && cemeteryId!=null){
            memorialPresenter.load(cemeteryId);
            memorialPresenter.loadCemeterySummary(cemeteryId);
        }


    }

    private void onClickListener() {
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Memorial memorial) {
                Intent mIntent = new Intent(MemorialActivity.this,MemorialInfoActivity.class);
                mIntent.putExtra(MEMORIAL_ITEM,memorial);
                startActivity(mIntent);
            }
        });
    }

    private void attachPresenterCallBack() {
        if(memorialPresenter!=null){
            memorialPresenter.attach(this);
        }
    }

    private void setUpToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("  " + getString(R.string.memorials));
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void addResults(List<Memorial> memorialList) {
        //Log.i("adarsh memorialList",memorialList.size()+"");
        adapter.setData(memorialList);
        adapter.notifyDataSetChanged();
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
        binding.recyclerView.setVisibility(View.GONE);
        binding.emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyResultsView() {

    }

    @Override
    public void showCemeterySummary(Cemetery mCemetery)
    {
        /*if(mCemetery.getCemeteryName()!=null){
            binding.cemeteryName.setText(mCemetery.getCemeteryName());
        }*/

        /*if(mCemetery.getStateName()!=null && mCemetery.getStateName().length()!=0){
            binding.cemeteryCountry.setText(mCemetery.getStateName());
        }else if(mCemetery.getCountryName()!=null && mCemetery.getCountryName().length()!=0){
            binding.cemeteryCountry.setText(mCemetery.getCountryName());
        }*/
       // Log.i("Adarsh","In Cemetery Summary");
    }
}
