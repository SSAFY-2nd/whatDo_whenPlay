package com.example.loginregisterexample.VO;

import com.example.loginregisterexample.R;

import java.util.HashMap;

public class playNameMap {

    final HashMap<String, Integer> playNameMap = new HashMap<String, Integer>(){
        {
            put("전시회",R.drawable.exhibition);
            put("pc방",R.drawable.pcroom);
            put("당구장",R.drawable.billiardball);
            put("볼링장",R.drawable.bowling);
            put("낚시카페",R.drawable.fishing);
            put("vr",R.drawable.vrchat);
            put("오락실",R.drawable.arcade);
            put("헬스장",R.drawable.fitness);
            put("골프",R.drawable.golf);
            put("양궁",R.drawable.archery);
            put("연극",R.drawable.theater);
            put("방탈출",R.drawable.roomescape);
            put("영화관",R.drawable.movie);
            put("서점",R.drawable.bookstore);
            put("공원",R.drawable.park);
            put("시장",R.drawable.sizang);
            put("찜질방",R.drawable.sauna);
            put("공방",R.drawable.make);
            put("수영장",R.drawable.swimmingpool);
            put("탁구장",R.drawable.pingpong);
            put("박물관",R.drawable.museum);
            put("문화재",R.drawable.cultural_heritage);
        }

    };

    @Override
    public String toString() {
        return "playNameMap{" +
                "playNameMap=" + playNameMap +
                '}';
    }

    public playNameMap() {
    }

    public Integer getPlayNameMap(String key) {
        return playNameMap.get(key);
    }
}
