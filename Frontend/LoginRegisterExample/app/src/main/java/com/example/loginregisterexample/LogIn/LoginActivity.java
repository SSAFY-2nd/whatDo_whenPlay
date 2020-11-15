package com.example.loginregisterexample.LogIn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.R;
import com.example.loginregisterexample.Register.RegisterActivity;
import com.example.loginregisterexample.VO.User;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText login_et_email, login_et_pw;
    private Button login_btn;
    private Button register_btn;
    static RequestQueue LoginQueue;
    static int findUserId = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        setTitle("로그인");

        
        login_et_email = findViewById(R.id.et_id);
        login_et_pw = findViewById(R.id.et_pass);
        // 로그인 버튼
        login_btn = findViewById(R.id.btn_login);

        // LoginQueue 객체생성
        if (LoginQueue== null) {
            LoginQueue = Volley.newRequestQueue(this);
        }

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        
        // 회원가입 버튼
        register_btn = findViewById(R.id.btn_register);

        register_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                register();
            }
        });



    }

    private void login() {
        String user_id = login_et_email.getText().toString();
        String user_pw = login_et_pw.getText().toString();


        String URL = String.format("http://k3a304.p.ssafy.io:8399/account/login?nickname=%s&password=%s",user_id, user_pw);
        Log.v("URL_체크",URL);

        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
//                              Log.v("응답", response);
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject jsonObject2 = jsonObject.getJSONObject("data");

                            Toast.makeText(getApplicationContext(),"로그인 성공!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            // User 고유 id 넘겨주기
                            intent.putExtra("id", jsonObject2.getInt("id"));
                            startActivity(intent);
                            finish();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(getApplicationContext(),"로그인 실패!",Toast.LENGTH_SHORT).show();
                return;

            }
        }
        );

        // 캐쉬기능을 끊다. 바로바로 내용처리되도록
        request.setShouldCache(false);
        LoginQueue.add(request);

    }

    private void register(){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }


}
