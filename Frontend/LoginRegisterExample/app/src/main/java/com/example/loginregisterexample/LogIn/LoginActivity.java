package com.example.loginregisterexample.LogIn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.R;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText login_et_email, login_et_pw;
    private Button login_btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView( R.layout.home);
        setTitle("로그인");

        login_et_email = findViewById(R.id.et_id);
        login_et_pw = findViewById(R.id.et_pass);
        login_btn1 = findViewById(R.id.btn_login);

        login_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        final String user_id = login_et_email.getText().toString();
        String user_pw = login_et_pw.getText().toString();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    if (success != null && success.equals("1")) {
                        Toast.makeText(getApplicationContext(),"로그인 성공!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("user_id",user_id);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(),"로그인 실패!",Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getApplicationContext(),"로그인 처리시 에러발생!",Toast.LENGTH_SHORT).show();
                return;
            }
        };

        // Volley 로 로그인 양식 웹전송
        LoginRequest loginRequest = new LoginRequest(user_id,user_pw,responseListener,errorListener);


        loginRequest.setShouldCache(false);

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(loginRequest);

    }


}
