package com.example.loginregisterexample.Register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginregisterexample.R;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText join_email, join_password, join_name, join_nickname, join_pwck;
    private Button join_button, check_button;
    private AlertDialog dialog;
    private boolean validate = false;
    private static final String TAG = "TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState);

        setContentView( R.layout.signup);


        // 닉네임, 이름, 이메일, 비밀번호, 비밀번호 확인
        join_nickname = findViewById( R.id.et_nickname);
        join_name = findViewById( R.id.et_id);
        join_email = findViewById(R.id.et_email);
        join_password = findViewById(R.id.et_pass);
        join_pwck = findViewById(R.id.et_confirmpass);

        check_button = findViewById(R.id.check_button);
        check_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String NickName = join_nickname.getText().toString();

                // 여기까지는 정상 동작
                Log.v(NickName,"이것은 닉네임입니다.");

                if(validate){
                    return ; // 검증 완료
                }

                if(NickName.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("아이디를 입력하세요.").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }

                String URL = String.format("http://k3a304.p.ssafy.io:8399/api/account/info?nickname=%s", NickName);
                Log.e(URL, "이것은 수정된 URL입니다.");
                // get 방식으로 넘겨줌.

                String data = "";
                StringRequest request = new StringRequest(
                        Request.Method.GET,
                        URL,
                        new Response.Listener<String>(){
                            @Override
                            public void onResponse(String response) {
                                try{
                                    JSONObject jsonResponse = new JSONObject(response);
                                    boolean success = false;

                                    Log.v("갓상혁!!", jsonResponse.getString("data"));

                                    Log.v("갓상혁!!", ""+jsonResponse.getString("data").getClass() );
                                    if("null".equals(jsonResponse.getString("data"))){
                                        Log.v("갓갓!!","아이디 등록 가능");
                                        success = true;
                                    }
//                                    boolean success = jsonResponse.getBoolean("success");
                                    Log.v("B", "여기가 B");
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
                        },
                        new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError error){
                                Log.i("error response", error.getMessage());
                            }
                        }
                );

//                Response.Listener<String> responseListener = new Response.Listener<String>() {
//                    // 결과 처리?
//                    @Override
//                    public void onResponse(String response) {
//                        try{
//
//                            JSONObject jsonResponse = new JSONObject(response);
//                            Log.v(jsonResponse.toString(), "여기가 jsonResponse");
//                            boolean success = jsonResponse.getBoolean("success");
//
//                            if(success){
//                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
//                                dialog = builder.setMessage("사용할 수 있는 아이디입니다.").setPositiveButton("확인", null).create();
//                                dialog.show();
//                                join_nickname.setEnabled(false); // 아이디 값 고정
//                                validate = true; // 검증 완료
//                                check_button.setBackgroundColor(getResources().getColor(R.color.colorGray));
//
//                            }else{
//                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
//                                dialog = builder.setMessage("이미 존재하는 아이디입니다.").setNegativeButton("확인", null).create();
//                                dialog.show();
//                            }
//                        }catch (JSONException e){
//                            e.printStackTrace();
//                        }
//                    }
//                };



                // post 방식으로 넘겨줌.
                //ValidateRequest validateRequest = new ValidateRequest(NickName, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(request);
            }
        });


        // 회원가입 버튼 클릭 시 수행
        join_button = findViewById( R.id.join_button);
        join_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // 닉네임, 이름, 이메일, 비밀번호, 비밀번호 확인
                final String NickName = join_nickname.getText().toString();
                final String UserName = join_name.getText().toString();
                final String UserEmail = join_email.getText().toString();
                final String UserPwd = join_password.getText().toString();
                final String PassCk = join_pwck.getText().toString();

                // 아이디 중복체크 했는 지 확인
                if(!validate){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("중복된 아이디가 있는지 확인하세요.").setNegativeButton("확인",null).create();
                    dialog.show();
                    return;
                }

                // 한 칸이라도 입력 안했을 경우
                if(NickName.equals("") || UserName.equals("") || UserEmail.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            // 회원가입 성공시
                            if(UserPwd.equals(PassCk)){
                                if(success){
                                    Toast.makeText(getApplicationContext(), String.format("%s님 가입을 환영합니다. ", UserName), Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                                    startActivity(intent);
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
                };

                // 서버로 Volley를 이용해서 요청
                // 닉네임, 이름, 이메일, 비밀번호, 비밀번호 확인
                RegisterRequest registerRequest = new RegisterRequest( UserName, NickName, UserEmail, UserPwd, responseListener );
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);

             }
        });

//        System.out.println(join_name);
//        System.out.println(join_nickname);
//        System.out.println(join_email);
//        System.out.println(join_password);
//        System.out.println(join_pwck);

        // 아이디 중복 체크
//        check_button = findViewById(R.id.)




    }


}
