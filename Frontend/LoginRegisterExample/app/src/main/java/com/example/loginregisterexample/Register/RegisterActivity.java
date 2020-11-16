package com.example.loginregisterexample.Register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginregisterexample.LogIn.LoginActivity;
import com.example.loginregisterexample.Playwithme.AppHelper;
import com.example.loginregisterexample.R;
import com.example.loginregisterexample.main_category.Frag0;


import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText join_email, join_password, join_name, join_nickname, join_pwck;
    private Button join_button, check_button;
    private AlertDialog dialog;
    private TextView resultTextView;
    private boolean validate = false;
//    private String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState);

        setContentView( R.layout.signup);


        // 닉네임, 이름, 이메일, 비밀번호, 비밀번호 확인
        join_nickname = findViewById( R.id.et_nickname);
        join_name = findViewById( R.id.et_name);
        join_email = findViewById(R.id.et_email);
        join_password = findViewById(R.id.et_pass);
        join_pwck = findViewById(R.id.et_confirmpass);

        check_button = findViewById(R.id.check_button);

        check_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                class NewRunnable implements Runnable{
                    @Override
                    public void run(){
                        sendRequest();
                    }
                }

                NewRunnable nr = new NewRunnable();
                Thread t = new Thread(nr);
                t.start();

            }
        });
//        Log.v("DD","DD");
        if(AppHelper.requestQueue == null) {
            AppHelper.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        // 회원가입 버튼 클릭 시 수행
        join_button = (Button)findViewById( R.id.join_button);

        join_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                class NewRunnable implements Runnable{
                    @Override
                    public void run(){
                        sendSignup();
                    }
                }

                NewRunnable nr = new NewRunnable();
                Thread t = new Thread(nr);
                t.start();





             }
        });



    }
    public void sendRequest(){
         String NickName = join_nickname.getText().toString();

        // 여기까지는 정상 동작
        Log.v("Nickname", NickName);


        if(validate){
            return ; // 검증 완료
        }

        if(NickName.equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            dialog = builder.setMessage("아이디를 입력하세요.").setPositiveButton("확인", null).create();
            dialog.show();
            return;
        }

        String URL = String.format("http://k3a304.p.ssafy.io:8399/account/info?nickname=%s", NickName);
        Log.e(URL, "이것은 수정된 URL입니다.");

        StringRequest request = new StringRequest( Request.Method.GET, URL, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = false;

                    if("null".equals(jsonResponse.getString("data"))){
                        success = true;
                    }
                    if(success){
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        dialog = builder.setMessage("사용할 수 있는 아이디입니다.").setPositiveButton("확인", null).create();
                        dialog.show();
                        join_nickname.setEnabled(false); // 아이디 값 고정
                        validate = true; // 검증 완료
                        check_button.setBackgroundColor(getResources().getColor(R.color.colorGray));

                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        dialog = builder.setMessage("이미 존재하는 아이디입니다.").setNegativeButton("확인", null).create();
                        dialog.show();
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Log.i("EE", "HERE");
//                Log.i("error response", error.getMessage());

            }
        }
        );

        request.setShouldCache(false);
        AppHelper.requestQueue.add(request);

    }

    public void sendSignup(){
        // 닉네임, 이름, 이메일, 비밀번호, 비밀번호 확인
        // 값을 텍스트화 하고 toString()으로 변환
        String NickName = join_nickname.getText().toString();
        String UserName = join_name.getText().toString();
        String UserEmail = join_email.getText().toString();
        String UserPwd = join_password.getText().toString();
        String PassCk = join_pwck.getText().toString();


        JSONObject jsonBody = new JSONObject();
        try{
            jsonBody.put("email", UserEmail);
            jsonBody.put("name", UserName);
            jsonBody.put("nickname", NickName);
            jsonBody.put("password", UserPwd);
        }catch(Exception e){
            e.printStackTrace();
        }

        // 아이디 중복체크 했는 지 확인
        if(!validate){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            dialog = builder.setMessage("중복된 아이디가 있는지 확인하세요.").setNegativeButton("확인",null).create();
            dialog.show();
            return;
        }

        if(NickName.getBytes().length <=0 || UserName.getBytes().length <=0 || UserEmail.getBytes().length <=0 || UserPwd.getBytes().length <=0 || PassCk.getBytes().length <=0){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
            dialog.show();
            return;
        }

        String URL = String.format("http://k3a304.p.ssafy.io:8399/account/signup");

//        RequestQueue postRequestqueue = Volley.newRequestQueue(RegisterActivity.this);
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try{
                    boolean success = true;

                    if("null".equals(response.getString("data"))){
                        success = true;
                    }

                    // 비밀번호와 비밀번호 Check가 같을 경우.
                    if(UserPwd.equals(PassCk)){
                        if(success){

                            Toast.makeText(getApplicationContext(), String.format("%s님 가입을 환영합니다. ", UserName), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            // 회원가입 실패시
                            Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        dialog = builder.setMessage("비밀번호가 동일하지 않습니다.").setNegativeButton("확인", null).create();
                        dialog.show();
                        return;
                    }
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                resultTextView.setText("Error getting response");
            }


        } );
        requestQueue.add(jsonObjectRequest);
    }


}
