package com.example.loginregisterexample.VO;

import com.example.loginregisterexample.R;

import java.util.HashMap;

public class foodNameMap {
    final HashMap<String, Integer> foodNameMap = new HashMap<String, Integer>(){
        {
            put("치킨", R.drawable.chicken);
            put("피자",R.drawable.pizza);
            put("분식",R.drawable.snack_bar);
            put("일식",R.drawable.sushi);
            put("중식",R.drawable.chinafood);
            put("한식",R.drawable.koreafood);
            put("양식",R.drawable.westernfood);
            put("족발",R.drawable.beef);
            put("카페",R.drawable.cafe);
            put("디저트",R.drawable.dessert);
            put("곱창",R.drawable.gibles);
            put("술집",R.drawable.soju);
            put("호프집",R.drawable.beer);
            put("칵테일바",R.drawable.cocktail);
            put("와인",R.drawable.wine);
            put("죽",R.drawable.jook);
            put("샐러드",R.drawable.salad);
            put("도시락",R.drawable.dosirak);
        }
    };

    public Integer getFoodNameMap(String key) {
        return foodNameMap.get(key);
    }

    public foodNameMap() {
    }
}
