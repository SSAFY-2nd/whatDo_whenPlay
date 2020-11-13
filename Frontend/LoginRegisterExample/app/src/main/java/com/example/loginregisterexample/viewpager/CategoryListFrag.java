package com.example.loginregisterexample.viewpager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.R;

import java.util.ArrayList;

public class CategoryListFrag extends Fragment {
    private View view;

    static public Context mContext;

    private RecyclerAdapter recyclerAdapter;
    private ArrayList<String> foodNameList;
    private ArrayList<String> playNameList;

    private ArrayList<ArrayList<SampleData>> categoryFoodList;
    private ArrayList<ArrayList<SampleData>> categoryPlayList;
    private int selectedPosition = 0;
    private static final int DP = 24;

    private TextView foodButton;
    private TextView playButton;

    static public LinearLayoutManager linearLayoutManager;
    static public RecyclerView recyclerView;

    static public ViewPager viewPager;

    private String genre = null;
    private String category = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.categorylist_activity,container,false);

        // 데이터 받기
        //Intent intent = MainActivity.mContext.getIntent();
        Bundle bundle = getArguments();

        //genre = intent.getStringExtra("genre");
        //category = intent.getStringExtra("category");
        genre = bundle.getString("genre");
        category = bundle.getString("category");
        Log.d("test",genre+" "+category);

        //mContext = this;
        this.initializeData();

        // two button
        foodButton = view.findViewById(R.id.categoryFoodButton);
        playButton = view.findViewById(R.id.categoryPlayButton);

        // 놀거리 먹거리 버튼 선택 색깔
        if(genre.equals("놀거리")) {
            selectedPosition = 1;
        }
        if(selectedPosition == 0) {
            foodButton.setBackgroundResource(R.drawable.food_play_ripple_effect_click);
            playButton.setBackgroundResource(R.drawable.food_play_ripple_effect);
        } else {
            foodButton.setBackgroundResource(R.drawable.food_play_ripple_effect);
            playButton.setBackgroundResource(R.drawable.food_play_ripple_effect_click);
        }
        // 위의 버튼 누를때
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedPosition == 0) {
                    return;
                }
                selectedPosition = 0;
                selectButton();
                recyclerAdapter = new RecyclerAdapter(foodNameList,0);
                recyclerView.setAdapter(recyclerAdapter);

                viewPager = view.findViewById(R.id.viewPager);
                viewPager.setAdapter(new ViewPagerAdapter(MainActivity.mContext, categoryFoodList));
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(selectedPosition == 1) {
                    return;
                }
                selectedPosition = 1;
                selectButton();
                recyclerAdapter = new RecyclerAdapter(playNameList, 0);
                recyclerView.setAdapter(recyclerAdapter);

                viewPager = view.findViewById(R.id.viewPager);
                viewPager.setAdapter(new ViewPagerAdapter(getActivity().getApplicationContext(), categoryPlayList));
            }
        });

        // button list
        linearLayoutManager = new LinearLayoutManager(MainActivity.mContext, LinearLayoutManager.HORIZONTAL, false);
        recyclerView = view.findViewById(R.id.buttonListView);
        recyclerView.setLayoutManager(linearLayoutManager);


        // 받아온 intent로 결정 디폴트 food
        if(genre.equals("놀거리")) {
            int position = playNameList.indexOf(category);
            recyclerAdapter = new RecyclerAdapter(playNameList,position);
        } else {
            int position = foodNameList.indexOf(category);
            recyclerAdapter = new RecyclerAdapter(foodNameList,position);
        }
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setItemAnimator(null);


        // list viewPager
        viewPager = view.findViewById(R.id.viewPager);
        Log.d("test",genre);
        if(genre.equals("놀거리")) {
            viewPager.setAdapter(new ViewPagerAdapter(MainActivity.mContext, categoryPlayList));
            Log.d("test",categoryPlayList.indexOf(category)+"");
            viewPager.setCurrentItem(playNameList.indexOf(category));
        } else {
            viewPager.setAdapter(new ViewPagerAdapter(MainActivity.mContext, categoryFoodList));
            viewPager.setCurrentItem(foodNameList.indexOf(category));
        }

        return view;
    }

    public void selectButton() {
        if(selectedPosition == 0) {
            foodButton.setBackgroundResource(R.drawable.food_play_ripple_effect_click);
            playButton.setBackgroundResource(R.drawable.food_play_ripple_effect);
        } else {
            foodButton.setBackgroundResource(R.drawable.food_play_ripple_effect);
            playButton.setBackgroundResource(R.drawable.food_play_ripple_effect_click);
        }
    }

    public void initializeData()
    {
        foodNameList = new ArrayList<>();
        foodNameList.add("전체");
        foodNameList.add("치킨");
        foodNameList.add("피자");
        foodNameList.add("분식");
        foodNameList.add("일식");
        foodNameList.add("중식");
        foodNameList.add("한식");
        foodNameList.add("양식");
        foodNameList.add("족발");
        foodNameList.add("카페");
        foodNameList.add("피자");
        foodNameList.add("디저트");
        foodNameList.add("곱창");
        foodNameList.add("술집");
        foodNameList.add("호프집");
        foodNameList.add("칵테일바");
        foodNameList.add("와인");
        foodNameList.add("죽");
        foodNameList.add("샐러드");
        foodNameList.add("도시락");
        playNameList = new ArrayList<>();
        playNameList.add("전체");
        playNameList.add("전시회");
        playNameList.add("PC방");
        playNameList.add("당구장");
        playNameList.add("볼링장");
        playNameList.add("낚시");
        playNameList.add("VR");
        playNameList.add("오락실");
        playNameList.add("헬스장");
        playNameList.add("골프");
        playNameList.add("야구");
        playNameList.add("양궁");
        playNameList.add("연극");
        playNameList.add("방탈출");
        playNameList.add("영화관");
        playNameList.add("서점");
        playNameList.add("공원");
        playNameList.add("시장");
        playNameList.add("찜질방");
        playNameList.add("공방");
        playNameList.add("수영장");
        playNameList.add("탁구장");
        playNameList.add("박물관");
        playNameList.add("문화재");
        categoryFoodList = new ArrayList<ArrayList<SampleData>>();



        for (int i=0; i<foodNameList.size(); i++) {
            ArrayList<SampleData> temp = new ArrayList<>();
            temp.add(new SampleData(R.drawable.user_icon, foodNameList.get(i),"15세 이상관람가"));
            temp.add(new SampleData(R.drawable.user_icon, "미션임파서블","15세 이상관람가"));
            temp.add(new SampleData(R.drawable.user_icon, "아저씨","19세 이상관람가"));
            temp.add(new SampleData(R.drawable.user_icon, "어벤져스","12세 이상관람가"));
            categoryFoodList.add(temp);
        }

        categoryPlayList = new ArrayList<ArrayList<SampleData>>();

        for (int i=0; i<playNameList.size(); i++) {
            ArrayList<SampleData> temp = new ArrayList<>();
            temp.add(new SampleData(R.drawable.user_icon, "미션임파서블","15세 이상관람가"));
            temp.add(new SampleData(R.drawable.user_icon, "아저씨","19세 이상관람가"));
            temp.add(new SampleData(R.drawable.user_icon, "어벤져스","12세 이상관람가"));
            categoryPlayList.add(temp);
        }
    }
}
