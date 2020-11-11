package com.example.loginregisterexample.Playwithme;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class Frag2 extends Fragment {

    private View view;
    private EditText search_friend;
    private Button check_btn1;


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
                    Log.v("갓갓",it  jsonObject.toString());

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

    



}
