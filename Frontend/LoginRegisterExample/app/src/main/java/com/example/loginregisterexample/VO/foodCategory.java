package com.example.loginregisterexample.VO;

import java.util.HashMap;

public class foodCategory {
    final HashMap<Integer, String> foodCategory = new HashMap<Integer, String>(){
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

    public String getFoodCategory(Integer key) {
        return foodCategory.get(key);
    }

    public Integer getKey(String value) {
        for(Integer o: foodCategory.keySet()) {
            if(foodCategory.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "foodCategory{" +
                "foodCategory=" + foodCategory +
                '}';
    }

    public foodCategory() {
    }
}
