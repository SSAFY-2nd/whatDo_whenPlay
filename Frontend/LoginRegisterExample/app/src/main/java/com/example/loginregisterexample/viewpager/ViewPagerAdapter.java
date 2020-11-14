package com.example.loginregisterexample.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.loginregisterexample.R;
import com.example.loginregisterexample.VO.Store;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<ArrayList<Store>> categoryList;

    public ViewPagerAdapter(Context context, ArrayList<ArrayList<Store>> categoryList) {
        this.mContext = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.categorylist_pagerview_layout, null);

        ListView listView = (ListView)view.findViewById(R.id.listView);
        final ListAdapter listAdapter = new ListAdapter(mContext,categoryList.get(position));
        listView.setAdapter(listAdapter);

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View)object);
    }
}
