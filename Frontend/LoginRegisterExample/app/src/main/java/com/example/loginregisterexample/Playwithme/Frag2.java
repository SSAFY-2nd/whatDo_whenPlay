package com.example.loginregisterexample.Playwithme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.loginregisterexample.LogIn.LoginActivity;
import com.example.loginregisterexample.LogIn.LoginRequest;
import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Frag2 extends Fragment {

    private View view;
    private EditText search_friend;
    private Button check_btn1;

    private AutoCompleteTextView autoCompleteTextView;
    private List<String> station_list;

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

        view = inflater.inflate(R.layout.playwithme,container,false);

        station_list = new ArrayList<>();
        settingList();
        autoCompleteTextView = (AutoCompleteTextView)view.findViewById(R.id.et_choice_station);
        // AutoCompleteTextView 에 아답터를 연결한다.
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(MainActivity.mContext, android.R.layout.simple_dropdown_item_1line,  station_list));

        search_friend = view.findViewById(R.id.et_id);
        check_btn1 = view.findViewById(R.id.btn_choice_partner);

        check_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                class NewRunnable implements Runnable{
                    @Override
                    public void run(){
                        searchFriend();
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


        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    // ID 입력하여 존재하는 Email인지 확인.
                    // 존재한다면 "@@님" 확인되었습니다.
                    // 존재하지않는다면 "아이디를 다시 입력해주세요.!"
                    JSONObject jsonObject = new JSONObject(response);
                    //Log.v("갓갓",it  jsonObject.toString());

                    String success = jsonObject.getString("success");
                    if (success != null && success.equals("1")) {
                        Toast.makeText(getActivity(),"아이디 조회 성공!",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(),"아이디 조회 실패!",Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"아이디 조회시 에러발생!",Toast.LENGTH_SHORT).show();
                return;
            }
        };

        // Volley 로 친구 찾기 양식 웹전송
        FriendCheckRequest searchFriendRequest = new FriendCheckRequest(searchFriendId, responseListener, errorListener);
        searchFriendRequest.setShouldCache(false);

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(searchFriendRequest);

    }

    // 역은 강남역으로 FIX

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
