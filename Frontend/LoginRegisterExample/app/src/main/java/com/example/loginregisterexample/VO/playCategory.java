package com.example.loginregisterexample.VO;

import java.util.HashMap;

public class playCategory {
    final HashMap<Integer, String> playCategory = new HashMap<Integer, String>() {
        {
            put(1,"전시회");
            put(2, "PC방");
            put(3, "당구장");
            put(4, "볼링장");
            put(5, "낚시카페");
            put(6, "VR");
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

    public String getPlayCategory(Integer key) {
        return playCategory.get(key);
    }

    @Override
    public String toString() {
        return "playCategory{" +
                "playCategory=" + playCategory +
                '}';
    }

    public playCategory() {
    }
}
