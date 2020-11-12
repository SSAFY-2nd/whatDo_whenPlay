package com.example.loginregisterexample.Playwithme;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginregisterexample.R;
import com.example.loginregisterexample.VO.Play;
import com.example.loginregisterexample.VO.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Frag2 extends Fragment {

    private View view;
    private EditText search_friend;
    private Button check_btn1, check_btn2;
    static RequestQueue searchFriendRequest;
    private User user;
    private Play play;
    private ArrayList<Integer> listFood;
    private ArrayList<Integer> listPlay;
    private boolean check = false;

    public Frag2() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.playwithme,container,false);

        search_friend = view.findViewById(R.id.et_id);
        check_btn1 = view.findViewById(R.id.btn_choice_partner);

        check_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                searchFriend();
            }
        });

        // RequestQueue 객체생성
        if (searchFriendRequest == null) {
            searchFriendRequest = Volley.newRequestQueue(getActivity());
        }

        check_btn2 = view.findViewById(R.id.btn_playwith_me);

        check_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listFood = null;
                listPlay = null;
                check = false;

                searchPlaywithme();


                class NewRunnable implements Runnable{
                    @Override
                    public void run(){
                        while(true){
                            if(check){
                                Intent intent = new Intent(getActivity(), PlaywithmeLikelyActivity.class);

                                Log.v("AA",listPlay.toString());
                                // 화면전환
                                intent.putExtra("listplay", (ArrayList<Integer>) listPlay);
                                intent.putExtra("listfood", (ArrayList<Integer>) listFood);
                                Log.v("BB",listPlay.toString());
                                startActivity(intent);
                                break;
                            }
                        }
                    }
                }

                NewRunnable nr = new NewRunnable();
                Thread t = new Thread(nr);
                t.start();




            }
        });


        return view;
    }

    private void searchFriend(){


        final String searchFriendId = search_friend.getText().toString();

        // 대표적인 예로 androidhive의 테스트 url을 삽입했다. 이부분을 자신이 원하는 부분으로 바꾸면 될 터
        String URL = String.format("http://k3a304.p.ssafy.io:8399/api/account/info?nickname=%s", searchFriendId);
        Log.v("갓갓",URL);

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
//                            Log.v("갓갓", response);

                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject jsonObject2 = jsonObject.getJSONObject("data");
                            user = new User();

                            user.setId(jsonObject2.getInt("id"));
                            user.setName(jsonObject2.getString("name"));
                            user.setNickname(jsonObject2.getString("nickname"));
                            user.setPassword(jsonObject2.getString("password"));
                            user.setEmail(jsonObject2.getString("email"));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.i("EE", "HERE");

                    }
            }
        );

        // 캐쉬기능을 끊다. 바로바로 내용처리되도록
        request.setShouldCache(false);
        searchFriendRequest.add(request);




    }
    private void searchPlaywithme(){

        // 강남역 -> 1로

        // Volley 로 친구 찾기 양식 웹전송
        // /together/{user_id}/{friend_name}/{subway_id}
        // URL 주소로 user_id : id
        // friend_name : nickname
        // subway_id : id

        // 리스트를 받아서 다음 페이지로 넘겨줘야함.
        int user_id = 1;
        String friend_name = user.getName();
        int subway_id= 1;

        String URL = String.format("http://k3a304.p.ssafy.io:8399/together/%d/%s/%d", user_id,friend_name,subway_id);
        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonFood = jsonObject.getJSONArray("subfood");
                            JSONArray jsonPlay = jsonObject.getJSONArray("subplay");
                            listPlay = new ArrayList<>();
                            listFood = new ArrayList<>();
                            listFood.clear();
                            listPlay.clear();

                            for(int i=0; i<jsonFood.length(); i++){
                                listFood.add(Integer.parseInt(jsonFood.get(i).toString()));
                            }
                            for(int i=0; i<jsonPlay.length(); i++){
                                listPlay.add(Integer.parseInt(jsonPlay.get(i).toString()));
                            }

                            Log.v("CC",listFood.toString());
                            //play = new Play(listPlay, listFood);

                            check = true;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.i("EE", "HERE");

                }
            }
        );

        // 캐쉬기능을 끊다. 바로바로 내용처리되도록
        request.setShouldCache(false);
        searchFriendRequest.add(request);

    }







}
