package com.ancestry.cemetery.View.Activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ancestry.cemetery.CemeteryApplication;
import com.ancestry.cemetery.Network.GetMemorialImageService;
import com.ancestry.cemetery.Network.GetMemorialService;
import com.ancestry.cemetery.Presenter.Model.Memorial;
import com.ancestry.cemetery.Presenter.Model.MemorialList;
import com.ancestry.cemetery.Presenter.Model.MemorialPhotoList;
import com.ancestry.cemetery.R;
import com.ancestry.cemetery.Utils.DateHelperClass;
import com.ancestry.cemetery.databinding.ActivityMemorialInfoBinding;
import com.squareup.picasso.Picasso;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import static com.ancestry.cemetery.Utils.Constants.MEMORIAL_ITEM;

/**
 * Created by adarsh on 4/5/2017.
 */

public class MemorialInfoActivity extends AppCompatActivity {

    ActivityMemorialInfoBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_memorial_info);
        setUpToolBar();
        populateUI(getIntent());
    }

    private void populateUI(Intent mIntent) {

        Memorial memorial = mIntent.getExtras().getParcelable(MEMORIAL_ITEM);
        if (memorial != null) {

            getImageUrl(memorial.getMemorialId());

            if (memorial.getFirstName() != null && memorial.getFirstName().trim().length() != 0) {
                binding.firstName.setText(memorial.getFirstName());
            } else {
                binding.firstName.setText(getString(R.string.unknown));
            }

            if (memorial.getLastName() != null && memorial.getLastName().trim().length() != 0) {
                binding.lastName.setText(memorial.getLastName());
            } else {
                binding.lastName.setText(getString(R.string.unknown));
            }

            if (memorial.getMaidenName() != null && memorial.getMaidenName().trim().length() != 0) {
                binding.middleName.setText(memorial.getMaidenName());
            } else {
                binding.middleName.setText(getString(R.string.unknown));
            }

            StringBuilder dateOfBirth = DateHelperClass.getDateOfBirth(memorial);

            StringBuilder dateOfDeath = DateHelperClass.getDateOfDeath(memorial);

            binding.birthDate.setText(dateOfBirth.toString());

            binding.deathDate.setText(dateOfDeath.toString());

            if (memorial.getCemeteryCountyName() != null && memorial.getCemeteryCountyName().trim().length() != 0) {
                binding.countyName.setText(memorial.getCemeteryCountyName());
            } else {
                binding.countyName.setText(getString(R.string.unknown));
            }

            if (memorial.getCemeteryName() != null && memorial.getCemeteryName().trim().length() != 0) {
                binding.cemeteryName.setText(memorial.getCemeteryName());
            } else {
                binding.cemeteryName.setText(getString(R.string.unknown));
            }

        }

    }

    private void setUpToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //No time, hence haven't followed the MVP,
    // Please don't consider this code as complete, it should be moved to model

    private void getImageUrl(String memorialId) {
        Retrofit mRetrofit = ((CemeteryApplication) getApplication()).getNetComponent().retrofit();
        Observable<MemorialPhotoList> observable = mRetrofit.create(GetMemorialImageService.class).getMemorialPhotoList(memorialId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MemorialPhotoList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MemorialPhotoList mMemorialList) {
                        if(mMemorialList.getMemorialPhotoList().size()!=0){
                            setImage(mMemorialList.getMemorialPhotoList().get(0).getFileName());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public void setImage(String image) {
        if(image!=null){
            Picasso.with(this).load(image)
                    .into(binding.backdrop);
        }
    }
}
