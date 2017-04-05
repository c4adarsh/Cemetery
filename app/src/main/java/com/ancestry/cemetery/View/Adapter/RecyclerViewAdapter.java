package com.ancestry.cemetery.View.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ancestry.cemetery.Presenter.Model.Memorial;
import com.ancestry.cemetery.R;
import com.ancestry.cemetery.Utils.DateHelperClass;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by adarsh on 4/4/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private List<Memorial> memorialList;
    private Context mContext;
    private OnItemClickListener onItemClickListener;


    public RecyclerViewAdapter(Context context, List<Memorial> memorialList) {
        this.memorialList = memorialList;
        this.mContext = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(List<Memorial> data) {
        this.memorialList = data;
    }

    public void loadMoreData(List<Memorial> data){
        this.memorialList.addAll(data);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memorial_row, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final Memorial memorial = memorialList.get(position);

        //Render image using Picasso library
        if (!TextUtils.isEmpty(memorial.getThumbnailUrl())) {
            Picasso.with(mContext).load(memorial.getThumbnailUrl())
                    /*.error(R.drawable.placeholder)
                    * .placeholder(R.drawable.cemetery)*/
                    .resize(60,60)
                    .into(holder.mImageView);
        }

        StringBuilder name = getName(memorial);

        StringBuilder dateOfBirth = DateHelperClass.getDateOfBirth(memorial);

        StringBuilder dateOfDeath = DateHelperClass.getDateOfDeath(memorial);

        dateOfBirth.append(" - ").append(dateOfDeath);

        if(name.toString().trim().length()==0){
            name.append("Unknown Memorial");
        }
        holder.nameTv.setText(name.toString().trim());

        holder.dateOfBirthTv.setText(dateOfBirth.toString());

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(memorial);
            }
        };
        
        holder.mImageView.setOnClickListener(listener);
        holder.nameTv.setOnClickListener(listener);
        holder.dateOfBirthTv.setOnClickListener(listener);
        holder.dateOfDeathTv.setOnClickListener(listener);
        holder.itemView.setOnClickListener(listener);
    }

    @NonNull
    private StringBuilder getName(Memorial memorial) {
        StringBuilder name = new StringBuilder();

        if(memorial.getLastName()!=null){
            name.append(memorial.getLastName());
            name.append(" ");
        }

        if(memorial.getMaidenName()!=null){
            name.append(memorial.getMaidenName());
            name.append(" ");
        }

        if(memorial.getFirstName()!=null){
            name.append(memorial.getFirstName());
        }
        return name;
    }

    @Override
    public int getItemCount() {
        return (null != memorialList ? memorialList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        protected ImageView mImageView;

        protected TextView nameTv;

        protected TextView dateOfBirthTv;

        protected TextView dateOfDeathTv;

        protected View itemView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.mImageView = (ImageView) itemView.findViewById(R.id.memorial_image);
            this.nameTv = (TextView) itemView.findViewById(R.id.person_name);
            this.dateOfBirthTv = (TextView) itemView.findViewById(R.id.date_of_birth);
            this.dateOfDeathTv = (TextView) itemView.findViewById(R.id.date_of_death);
            this.itemView = itemView;
        }

    }
}
