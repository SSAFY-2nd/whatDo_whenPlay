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

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.R;
import com.example.loginregisterexample.VO.Store;
import com.example.loginregisterexample.VO.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public class CategoryListFrag extends Fragment {
    private View view;

    static public Context mContext;

    private RecyclerAdapter recyclerAdapter;
    private RecyclerAdapter playRecyclerAdapter;
    private RecyclerAdapter foodRecyclerAdapter;
    private ArrayList<String> foodNameList;
    private ArrayList<String> playNameList;

    private ArrayList<ArrayList<Store>> categoryFoodList;
    private ArrayList<ArrayList<Store>> categoryPlayList;
    private int selectedPosition = 0;
    private static final int DP = 24;

    private TextView foodButton;
    private TextView playButton;

    static public LinearLayoutManager linearLayoutManager;
    static public RecyclerView recyclerView;

    static public ViewPager viewPager;

    private String genre = "놀거리";
    private String category = null;

    static RequestQueue searchFriendRequest2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.categorylist_activity,container,false);

        // RequestQueue 객체생성
        if (searchFriendRequest2 == null) {
            searchFriendRequest2 = Volley.newRequestQueue(getActivity());
        }

        // 데이터 받기
        //Intent intent = MainActivity.mContext.getIntent();
        Bundle bundle = getArguments();

        //genre = intent.getStringExtra("genre");
        //category = intent.getStringExtra("category");
        genre = bundle.getString("genre");
        category = bundle.getString("category");
        if(genre == null) {
            genre = "놀거리";
        }
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
        foodRecyclerAdapter = new RecyclerAdapter(foodNameList,0);
        playRecyclerAdapter = new RecyclerAdapter(playNameList,0);
        // 위의 버튼 누를때
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedPosition == 0) {
                    return;
                }
                selectedPosition = 0;
                selectButton();
                recyclerAdapter = foodRecyclerAdapter;

                linearLayoutManager = new LinearLayoutManager(MainActivity.mContext, LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);

                recyclerView.setAdapter(recyclerAdapter);
                recyclerView.setItemAnimator(null);

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

                recyclerAdapter = playRecyclerAdapter;

                linearLayoutManager = new LinearLayoutManager(MainActivity.mContext, LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);

                recyclerView.setAdapter(recyclerAdapter);
                recyclerView.setItemAnimator(null);

                viewPager = view.findViewById(R.id.viewPager);
                viewPager.setAdapter(new ViewPagerAdapter(MainActivity.mContext, categoryPlayList));
            }
        });

        // button list
        linearLayoutManager = new LinearLayoutManager(MainActivity.mContext, LinearLayoutManager.HORIZONTAL, false);
        recyclerView = view.findViewById(R.id.buttonListView);
        recyclerView.setLayoutManager(linearLayoutManager);


        // 받아온 intent로 결정 디폴트 food
        if(genre.equals("놀거리")) {
            int position = playNameList.indexOf(category);
            recyclerAdapter = playRecyclerAdapter;
        } else {
            int position = foodNameList.indexOf(category);
            recyclerAdapter = foodRecyclerAdapter;
        }
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setItemAnimator(null);


        // list viewPager
        viewPager = view.findViewById(R.id.viewPager);
        Log.d("test",genre);
        if(genre.equals("놀거리")) {
            viewPager.setAdapter(new ViewPagerAdapter(MainActivity.mContext, categoryPlayList));
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
        categoryFoodList = new ArrayList<ArrayList<Store>>();

        for (int i=0; i<foodNameList.size(); i++) {
            ArrayList<Store> temp = new ArrayList<>();
            categoryFoodList.add(temp);
        }

        // 데이터 받기
        // 대표적인 예로 androidhive의 테스트 url을 삽입했다. 이부분을 자신이 원하는 부분으로 바꾸면 될 터
        // 1 강남역
        String URL = String.format("http://k3a304.p.ssafy.io:8399/foodstore/sub/%d", 1);


        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            // ID 입력하여 존재하는 Email인지 확인.
                            // 존재한다면 "@@님" 확인되었습니다.
                            // 존재하지않는다면 "아이디를 다시 입력해주세요.!"
                            JSONArray jsonObj = null;
                            jsonObj = new JSONArray(response);

                            for(int i=0; i<jsonObj.length(); i++){
                                Store store = new Store();
                                JSONObject temp = jsonObj.getJSONObject(i);
                                store.setId(temp.getString("id"));
                                store.setSubway_id(temp.getString("subway_id"));
                                store.setCategory(temp.getString("category"));
                                store.setName(temp.getString("name"));
                                store.setTotReview(temp.getString("totReview"));
                                store.setRating(temp.getString("rating"));
                                store.setAddress(temp.getString("address"));
                                store.setDistance(temp.getString("distance"));
                                store.setPhoneNumber(temp.getString("phoneNumber"));
                                store.setWorkingTime(temp.getString("workingTime"));
                                store.setIntroduce(temp.getString("introduce"));
                                store.setMenu(temp.getString("menu"));
                                store.setPicture(temp.getString("picture"));
                                categoryFoodList.get(0).add(store);
                                categoryFoodList.get(Integer.parseInt(store.getCategory())).add(store);
                                Log.d("test",store.toString());
                            }
                        }catch (Exception e){
                            Log.v("E", e.getMessage());
                        }

                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Log.i("EE", "HERE");

            }
        }
        ){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    // log error
                    return Response.error(new ParseError(e));
                } catch (Exception e) {
                    // log error
                    return Response.error(new ParseError(e));
                }
            }
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

        // 캐쉬기능을 끊다. 바로바로 내용처리되도록
        request.setShouldCache(false);
        searchFriendRequest2.add(request);

        categoryPlayList = new ArrayList<ArrayList<Store>>();

        for (int i=0; i<playNameList.size(); i++) {
            ArrayList<Store> temp = new ArrayList<>();
            categoryPlayList.add(temp);
        }

        // 데이터 받기
        // 대표적인 예로 androidhive의 테스트 url을 삽입했다. 이부분을 자신이 원하는 부분으로 바꾸면 될 터
        // 1 강남역
        String play_URL = String.format("http://k3a304.p.ssafy.io:8399/playStore/sub/%d", 1);


        StringRequest play_request = new StringRequest(
                Request.Method.GET,
                play_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            // ID 입력하여 존재하는 Email인지 확인.
                            // 존재한다면 "@@님" 확인되었습니다.
                            // 존재하지않는다면 "아이디를 다시 입력해주세요.!"
                            JSONArray jsonObj = null;
                            jsonObj = new JSONArray(response);

                            for(int i=0; i<jsonObj.length(); i++){
                                Store store = new Store();
                                JSONObject temp = jsonObj.getJSONObject(i);
                                store.setId(temp.getString("id"));
                                store.setSubway_id(temp.getString("subway_id"));
                                store.setCategory(temp.getString("category"));
                                store.setName(temp.getString("name"));
                                store.setTotReview(temp.getString("totReview"));
                                store.setRating(temp.getString("rating"));
                                store.setAddress(temp.getString("address"));
                                store.setDistance(temp.getString("distance"));
                                store.setPhoneNumber(temp.getString("phoneNumber"));
                                store.setWorkingTime(temp.getString("workingTime"));
                                store.setIntroduce(temp.getString("introduce"));
                                store.setMenu(temp.getString("menu"));
                                store.setPicture(temp.getString("picture"));
                                categoryPlayList.get(0).add(store);
                                categoryPlayList.get(Integer.parseInt(store.getCategory())).add(store);
                                Log.d("test",store.toString());
                            }
                        }catch (Exception e){
                            Log.v("E", e.getMessage());
                        }

                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Log.i("EE", "HERE");

            }
        }
        ){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    // log error
                    return Response.error(new ParseError(e));
                } catch (Exception e) {
                    // log error
                    return Response.error(new ParseError(e));
                }
            }
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

        // 캐쉬기능을 끊다. 바로바로 내용처리되도록
        request.setShouldCache(false);
        searchFriendRequest2.add(play_request);
    }
}
