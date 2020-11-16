package com.example.loginregisterexample.viewpager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.R;
import com.example.loginregisterexample.VO.Store;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<Store> stores;

    public ListAdapter(Context context, ArrayList<Store> data) {
        mContext = context;
        stores = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return stores.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Store getItem(int position) {
        return stores.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.categorylist_listview_layout, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.poster);
        TextView movieName = (TextView)view.findViewById(R.id.movieName);
        TextView grade = (TextView)view.findViewById(R.id.grade);

        //imageView.setImageResource(sample.get(position).getPoster());
        Glide.with(view.getContext()).load(stores.get(position).getPicture()).into(imageView);
        movieName.setText(stores.get(position).getName());
        grade.setText(stores.get(position).getRating());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("touch","touch");
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("화면",5);
                intent.putExtra("store_name",stores.get(position).getName());
                intent.putExtra("store_review",stores.get(position).getTotReview());
                intent.putExtra("store_rating",stores.get(position).getRating());
                intent.putExtra("store_address",stores.get(position).getAddress());
                intent.putExtra("store_phoneNumber",stores.get(position).getPhoneNumber());
                intent.putExtra("store_workingTime",stores.get(position).getWorkingTime());
                intent.putExtra("store_introduce",stores.get(position).getIntroduce());
                intent.putExtra("store_menu",stores.get(position).getMenu());
                intent.putExtra("store_picture",stores.get(position).getPicture());
                v.getContext().startActivity(intent);
            }
        });

        return view;
    }
}
