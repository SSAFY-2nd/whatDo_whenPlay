package com.example.loginregisterexample.Playwithme;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.loginregisterexample.R;

import java.util.ArrayList;
import java.util.HashMap;

public class PlaywithmeLikelyActivity extends AppCompatActivity {

    private View view;

    public final HashMap<Integer, String> foodCategory = new HashMap<Integer, String >(){
        {
            put(1,"치킨");
            put(2, "피자");
            put(3, "분식");
            put(4, "일삭");
            put(5, "중식");
            put(6, "한식");
            put(7, "양식");
            put(8, "족발");
            put(9, "카페");
            put(10, "디저트");
            put(11, "곱창");
            put(12, "술집");
            put(13, "호프집");
            put(14, "칵테일바");
            put(15, "와인");
            put(16, "죽");
            put(17, "샐러드");
            put(18, "도시락");
        }
    };

    public final HashMap<Integer, String> playCategory = new HashMap<Integer, String >(){
        {
            put(1,"전시회");
            put(2, "pc방");
            put(3, "당구장");
            put(4, "볼링장");
            put(5, "낚시카페");
            put(6, "vr");
            put(7, "오락실");
            put(8, "헬스장");
            put(9, "골프");
            put(10, "양궁");
            put(11, "연극");
            put(12, "방탈출");
            put(13, "영화관");
            put(14, "서점");
            put(15, "공원");
            put(16, "시장");
            put(17, "찜질방");
            put(18, "공방");
            put(19, "수영장");
            put(20, "탁구장");
            put(21, "박물관");
            put(22, "문화재");
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.playwithme_likely);
        Intent intent = getIntent();

        ArrayList<Integer> listPlay = getIntent().getIntegerArrayListExtra("listplay");
        ArrayList<Integer> listFood = getIntent().getIntegerArrayListExtra("listfood");

        // 놀거리 강추 3, 추천 3, 먹거리 강추 3, 추천 3
        



    }


}
