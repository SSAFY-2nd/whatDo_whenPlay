package com.example.loginregisterexample.main_category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.R;
import com.example.loginregisterexample.viewpager.RecyclerAdapter;

import java.util.ArrayList;
import java.util.Map;

public class Frag0 extends Fragment {

    private View view;
    private MainRecyclerAdapter foodAdapter;
    private MainRecyclerAdapter playAdapter;
    private ArrayList<MainCategoryData> foodCategoryData;
    private ArrayList<MainCategoryData> playCategoryData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        //view = inflater.inflate(R.layout.home,container,false);
        view = inflater.inflate(R.layout.main_category,container,false);

        RecyclerView foodRecyclerView = view.findViewById(R.id.main_food_category_list);
        LinearLayoutManager foodLinearLayoutManager = new LinearLayoutManager(MainActivity.mContext,LinearLayoutManager.HORIZONTAL, false);
        foodRecyclerView.setLayoutManager(foodLinearLayoutManager);

        RecyclerView playRecyclerView = view.findViewById(R.id.main_play_category_list);
        LinearLayoutManager playLinearLayoutManager = new LinearLayoutManager(MainActivity.mContext,LinearLayoutManager.HORIZONTAL, false);
        playRecyclerView.setLayoutManager(playLinearLayoutManager);

        foodCategoryData = new ArrayList<>();
        
        for(int i=0; i<10; ++i) {
            MainCategoryData temp = new MainCategoryData(null,null);
            temp.setImage1(R.drawable.pizza_icon);
            temp.setImage2(R.drawable.pizza_icon);
        }
        foodAdapter = new MainRecyclerAdapter(foodCategoryData);
        foodRecyclerView.setAdapter(foodAdapter);
        for(int i=0; i<10; ++i) {
            MainCategoryData temp = new MainCategoryData(null,null);
            temp.setImage1(R.drawable.icons8_medium_icons_96);
            temp.setImage2(R.drawable.icons8_medium_icons_96);
            foodAdapter.addItem(temp);
        }
        foodAdapter.notifyDataSetChanged();

        playCategoryData = new ArrayList<>();
        for(int i=0; i<10; ++i) {
            MainCategoryData temp = new MainCategoryData(null,null);
            temp.setImage1(R.drawable.pizza_icon);
            temp.setImage2(R.drawable.pizza_icon);
        }
        playAdapter = new MainRecyclerAdapter(playCategoryData);
        playRecyclerView.setAdapter(playAdapter);
        for(int i=0; i<10; ++i) {
            MainCategoryData temp = new MainCategoryData(null,null);
            temp.setImage1(R.drawable.icons8_medium_icons_96);
            temp.setImage2(R.drawable.icons8_medium_icons_96);
            playAdapter.addItem(temp);
        }
        playAdapter.notifyDataSetChanged();


        return view;
    }



}
