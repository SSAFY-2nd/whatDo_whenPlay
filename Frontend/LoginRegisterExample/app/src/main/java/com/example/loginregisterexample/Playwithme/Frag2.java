package com.example.loginregisterexample.Playwithme;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.R;
import com.example.loginregisterexample.VO.Play;
import com.example.loginregisterexample.VO.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Frag2 extends Fragment {

    private View view;
    private EditText search_friend;
    private Button check_btn1, check_btn2, check_subway;
    static RequestQueue searchFriendRequest;
    private User user;
    private Play play;
    private ArrayList<Integer> listFood;
    private ArrayList<Integer> listPlay;
    private boolean check = false;
    private String curId = "";

    private AutoCompleteTextView autoCompleteTextView;
    private List<String> station_list;


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

        /*View v = inflater.inflate(R.layout.playwithme, container, false);
        // 역 자동완성
        station_list = new ArrayList<>();
        settingList();
        autoCompleteTextView = (AutoCompleteTextView)view.findViewById(R.id.et_choice_station);
        // AutoCompleteTextView 에 아답터를 연결한다.
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(MainActivity.mContext, android.R.layout.simple_dropdown_item_1line,  station_list));*/
        //Log.d("subway",getArguments().getString("subway"));
        view = inflater.inflate(R.layout.playwithme,container,false);


        Bundle bundle = getArguments();
        curId = bundle.getString("id");
        station_list = new ArrayList<>();
        settingList();
        autoCompleteTextView = (AutoCompleteTextView)view.findViewById(R.id.et_choice_station);
        // AutoCompleteTextView 에 아답터를 연결한다.
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(MainActivity.mContext, android.R.layout.simple_dropdown_item_1line,  station_list));
        Bundle bundle2 = getArguments();
        String subway = bundle2.getString("subway");

        if(subway != null) {
            autoCompleteTextView.setText(subway);
        }


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
        String URL = String.format("http://k3a304.p.ssafy.io:8399/account/info?nickname=%s", searchFriendId);
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
                            Toast.makeText(getContext(), String.format("%s님 친구 찾기 성공! ", user.getNickname()), Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            Toast.makeText(getContext(), String.format("친구 찾기 실패! "), Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Toast.makeText(getContext(), String.format("친구 찾기 실패! "), Toast.LENGTH_SHORT).show();

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
        int user_id = Integer.parseInt(curId);
        String friend_name = user.getNickname();
        int subway_id= 1;
        Log.v("frined_name", friend_name);
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


    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList(){
        String[] stations_2 = {"강남","역삼","선릉","삼성","종합운동장","잠실새내","잠실","잠실나루","강변","구의","건대입구","성수","용답",
                        "뚝섬","한양대","왕십리","신답","용두","신설동","상왕십리","신당","동대문역사문화공원","을지로4가","을지로3가",
                        "을지로입구","시청","충정로","아현","이대","신촌","홍대입구","합정","당산","영등포구청","문래","신도림","도림천",
                        "양천구청","신정네거리","까치산","대림","구로디지털단지","신대방","신림","봉천","서울대입구","낙성대","사당","방배",
                        "서초","교대"};
        for (int i=0; i<stations_2.length; ++i) {
            station_list.add(stations_2[i]);
        }
    }



}
