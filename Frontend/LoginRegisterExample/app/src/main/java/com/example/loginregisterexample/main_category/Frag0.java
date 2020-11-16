package com.example.loginregisterexample.main_category;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginregisterexample.LogIn.LoginActivity;
import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.Playwithme.PlaywithmeLikelyActivity;
import com.example.loginregisterexample.R;
import com.example.loginregisterexample.Register.RegisterActivity;
import com.example.loginregisterexample.VO.Play;
import com.example.loginregisterexample.viewpager.RecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Frag0 extends Fragment {

    private View view;
    private MainRecyclerAdapter foodAdapter;
    private MainRecyclerAdapter playAdapter;
    private ArrayList<MainCategoryData> foodCategoryData;
    private ArrayList<MainCategoryData> playCategoryData;
    public static Map<String, Integer> foodNameMap;

    final AtomicInteger requestsCounter = new AtomicInteger(0);

    static private ArrayList<Integer> curPlayState = new ArrayList<>();
    static private ArrayList<Integer> curFoodState = new ArrayList<>();
    static RequestQueue Queue;
//    static RequestQueue foodQueue;

    private String curId = "";
    private Button storeBtn;

    private TextView tasteList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        Bundle bundle = getArguments();
        curId = bundle.getString("id");

        view = inflater.inflate(R.layout.main_category,container,false);

        Queue = Volley.newRequestQueue(getContext());

        getRequest();


        Queue.addRequestFinishedListener(request -> {
            requestsCounter.decrementAndGet();
            if (requestsCounter.get() == 0) {

//                Log.v("fff",curPlayState.toString());
//                Log.v("cccc",curFoodState.toString());

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

                foodAdapter = new MainRecyclerAdapter(foodCategoryData,"먹거리",foodInput,curId, curFoodState);
                foodRecyclerView.setAdapter(foodAdapter);


                for(int i=0; i<(foodInput.length+1)/2; ++i) {
                    MainCategoryData temp = new MainCategoryData(null,null,null,null);
                    temp.setImage1(foodNameMap.get(foodInput[i*2]));
                    temp.setText1(foodInput[i*2]);
                    if((i*2)+1<foodInput.length) {
                        temp.setImage2(foodNameMap.get(foodInput[(i*2)+1]));
                        temp.setText2(foodInput[(i*2)+1]);
                    }
                    foodAdapter.addItem(temp);
                }
                foodAdapter.notifyDataSetChanged();

                String[] playInput = {"전시회","PC방","당구","볼링장","낚시카페","VR","오락실","헬스장","골프","야구","양궁","연극","방탈출","영화관","서점",
                        "공원","시장","찜질방","공방","수영장","탁구장","박물관","문화재"};

                playCategoryData = new ArrayList<>();
                playAdapter = new MainRecyclerAdapter(playCategoryData,"놀거리",playInput,curId, curPlayState);
                Map<String, Integer> playNameMap = new HashMap<>();
                playNameMap.put("전시회",R.drawable.exhibition);
                playNameMap.put("PC방",R.drawable.pcroom);
                playNameMap.put("당구",R.drawable.billiardball);
                playNameMap.put("볼링장",R.drawable.bowling);
                playNameMap.put("낚시카페",R.drawable.fishing);
                playNameMap.put("VR",R.drawable.vrchat);
                playNameMap.put("오락실",R.drawable.arcade);
                playNameMap.put("헬스장",R.drawable.fitness);
                playNameMap.put("골프",R.drawable.golf);
                playNameMap.put("야구",R.drawable.baseball);
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
                playRecyclerView.setAdapter(playAdapter);



                for(int i=0; i<(playInput.length+1)/2; ++i) {
                    MainCategoryData temp = new MainCategoryData(null,null,null,null);
                    temp.setImage1(playNameMap.get(playInput[i*2]));
                    temp.setText1(playInput[(i*2)]);
                    if((i*2)+1<playInput.length) {
                        temp.setImage2(playNameMap.get(playInput[(i*2)+1]));
                        temp.setText2(playInput[(i*2)+1]);
                    }
                    playAdapter.addItem(temp);
                }

                playAdapter.notifyDataSetChanged();

                storeBtn = view.findViewById(R.id.store_taste);
                tasteList = view.findViewById(R.id.tasteList);

                storeBtn.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view){
                        Log.v("Food : " ,foodAdapter.getFoodData().toString());
                        Log.v("Play : ", playAdapter.getPlayData().toString());
                        String tt = "먹거리 : " +  foodAdapter.getFoodData().toString() + " 놀거리 : "+playAdapter.getPlayData().toString() ;
                        tasteList.setText(tt);
                        getFoodRequest();
                        getPlayRequest();
                        Log.v("FoodIdx : ", foodAdapter.getIdxFoodData().toString());
                        Log.v("playIdx : ", playAdapter.getIdxPlayData().toString());


                    }
                });
            }
        });




        return view;
    }

    private void getRequest(){

        // 놀거리
        String URL = String.format("http://k3a304.p.ssafy.io:8399/playtaste/%d", Integer.parseInt(curId));

        StringRequest playRequest = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            curPlayState.clear();
                            JSONArray jsonArray = new JSONArray(response);
                            for(int i=0; i<jsonArray.length(); i++){

                                curPlayState.add(Integer.parseInt(jsonArray.get(i).toString()));

                            }
                            Log.v("상혁좌", curPlayState.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

                return;

            }
        }
        );

        // 캐쉬기능을 끊다. 바로바로 내용처리되도록
        playRequest.setShouldCache(false);
        Queue.add(playRequest);
        requestsCounter.incrementAndGet();


        // 음식
        URL = String.format("http://k3a304.p.ssafy.io:8399/foodtaste/%d", Integer.parseInt(curId));


        StringRequest foodRequest = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            curFoodState.clear();
                            JSONArray jsonArray = new JSONArray(response);
                            for(int i=0; i<jsonArray.length(); i++){
                                curFoodState.add(Integer.parseInt(jsonArray.get(i).toString()));
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                return;

            }
        }
        );

        // 캐쉬기능을 끊다. 바로바로 내용처리되도록
        foodRequest.setShouldCache(false);
        Queue.add(foodRequest);
        requestsCounter.incrementAndGet();

    }

    private void getFoodRequest(){
        // 가지고 있는 데이터를 Post로 전송
        // mData 값을 가져오기.
        // 리스트 가져와서 POST 통신
        String URL = String.format("http://k3a304.p.ssafy.io:8399/foodtaste/insert/%s",curId);

        JSONObject jsonBody = new JSONObject();
        try{
            // list 값

            JSONObject jsonObj1 = new JSONObject();

            JSONArray jsonArr1 = new JSONArray();
//            jsonArr1.put("1");
//            jsonArr1.put("2");

            for(int i : foodAdapter.getIdxFoodData()){

                jsonArr1.put(Integer.toString(i));
            }

            jsonBody.put("category_id",jsonArr1);

            Log.v("JSONBODY",jsonBody.toString());
//            HashMap<String, String> maplisttemp = new HashMap<String,String>();
//            for
//            maplisttemp.put("category_id", i);
        }catch(Exception e){
            e.printStackTrace();
        }

//        RequestQueue postRequestqueue = Volley.newRequestQueue(RegisterActivity.this);
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try{

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }


        } );
        requestQueue.add(jsonObjectRequest);


    }

    private void getPlayRequest(){
        // 가지고 있는 데이터를 Post로 전송
        // mData 값을 가져오기.
        // 리스트 가져와서 POST 통신
        String URL = String.format("http://k3a304.p.ssafy.io:8399/playtaste/insert/%s",curId);

        JSONObject jsonBody = new JSONObject();
        try{
            // list 값

            JSONObject jsonObj1 = new JSONObject();

            JSONArray jsonArr1 = new JSONArray();

            for(int i : playAdapter.getIdxPlayData()){

                jsonArr1.put(Integer.toString(i));
            }

            jsonBody.put("category_id",jsonArr1);

            Log.v("JSONBODY",jsonBody.toString());
//            HashMap<String, String> maplisttemp = new HashMap<String,String>();
//            for
//            maplisttemp.put("category_id", i);
        }catch(Exception e){
            e.printStackTrace();
        }

//        RequestQueue postRequestqueue = Volley.newRequestQueue(RegisterActivity.this);
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try{
                    Toast.makeText(getActivity(), String.format("취향이 저장되었습니다."), Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }


        } );
        requestQueue.add(jsonObjectRequest2);


    }




}
