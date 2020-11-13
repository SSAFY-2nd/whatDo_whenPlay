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
import androidx.viewpager.widget.PagerAdapter;

import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.R;
import com.example.loginregisterexample.viewpager.RecyclerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Frag0 extends Fragment {

    private View view;
    private MainRecyclerAdapter foodAdapter;
    private MainRecyclerAdapter playAdapter;
    private ArrayList<MainCategoryData> foodCategoryData;
    private ArrayList<MainCategoryData> playCategoryData;
    public static Map<String, Integer> foodNameMap;
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
        String[] foodInput = {"치킨","피자","분식","일식","중식","한식","양식","족발","카페","디저트","곱창","술집","호프집","칵테일바","와인","죽","샐러드","도시락"};

        Map<String, Integer> foodNameMap = new HashMap<>();
        foodNameMap.put("치킨",R.drawable.chicken);
        foodNameMap.put("피자",R.drawable.pizza);
        foodNameMap.put("분식",R.drawable.snack_bar);
        foodNameMap.put("일식",R.drawable.sushi);
        foodNameMap.put("중식",R.drawable.chinafood);
        foodNameMap.put("한식",R.drawable.koreafood);
        foodNameMap.put("양식",R.drawable.westernfood);
        foodNameMap.put("족발",R.drawable.beef);
        foodNameMap.put("카페",R.drawable.cafe);
        foodNameMap.put("디저트",R.drawable.dessert);
        foodNameMap.put("곱창",R.drawable.gibles);
        foodNameMap.put("술집",R.drawable.soju);
        foodNameMap.put("호프집",R.drawable.beer);
        foodNameMap.put("칵테일바",R.drawable.cocktail);
        foodNameMap.put("와인",R.drawable.wine);
        foodNameMap.put("죽",R.drawable.jook);
        foodNameMap.put("샐러드",R.drawable.salad);
        foodNameMap.put("도시락",R.drawable.dosirak);

        foodAdapter = new MainRecyclerAdapter(foodCategoryData,"먹거리",foodInput);
        foodRecyclerView.setAdapter(foodAdapter);

        for(int i=0; i<(foodInput.length+1)/2; ++i) {
            MainCategoryData temp = new MainCategoryData(null,null);
            temp.setImage1(foodNameMap.get(foodInput[i*2]));
            if((i*2)+1<foodInput.length) {
                temp.setImage2(foodNameMap.get(foodInput[(i*2)+1]));
            }
            foodAdapter.addItem(temp);
        }
        foodAdapter.notifyDataSetChanged();


        playCategoryData = new ArrayList<>();
        String[] playInput = {"전시회","PC방","당구장","볼링장","낚시까페","VR","오락실","헬스장","골프","양궁","연극","방탈출","영화관","서점",
                "공원","시장","찜질방","공방","수영장","탁구장","박물관","문화재"};

        Map<String, Integer> playNameMap = new HashMap<>();
        playNameMap.put("전시회",R.drawable.exhibition);
        playNameMap.put("PC방",R.drawable.pcroom);
        playNameMap.put("당구장",R.drawable.billiardball);
        playNameMap.put("볼링장",R.drawable.bowling);
        playNameMap.put("낚시까페",R.drawable.fishing);
        playNameMap.put("VR",R.drawable.vrchat);
        playNameMap.put("오락실",R.drawable.arcade);
        playNameMap.put("헬스장",R.drawable.fitness);
        playNameMap.put("골프",R.drawable.golf);
        playNameMap.put("양궁",R.drawable.archery);
        playNameMap.put("연극",R.drawable.theater);
        playNameMap.put("방탈출",R.drawable.roomescape);
        playNameMap.put("영화관",R.drawable.movie);
        playNameMap.put("서점",R.drawable.bookstore);
        playNameMap.put("공원",R.drawable.park);
        playNameMap.put("시장",R.drawable.sizang);
        playNameMap.put("찜질방",R.drawable.sauna);
        playNameMap.put("공방",R.drawable.make);
        playNameMap.put("수영장",R.drawable.swimmingpool);
        playNameMap.put("탁구장",R.drawable.pingpong);
        playNameMap.put("박물관",R.drawable.museum);
        playNameMap.put("문화재",R.drawable.cultural_heritage);

        playAdapter = new MainRecyclerAdapter(playCategoryData,"놀거리",playInput);
        playRecyclerView.setAdapter(playAdapter);

        for(int i=0; i<(playInput.length+1)/2; ++i) {
            MainCategoryData temp = new MainCategoryData(null,null);
            temp.setImage1(playNameMap.get(playInput[i*2]));
            if((i*2)+1<playInput.length) {
                temp.setImage2(playNameMap.get(playInput[(i*2)+1]));
            }
            playAdapter.addItem(temp);
        }
        playAdapter.notifyDataSetChanged();

        return view;
    }
}
