package com.example.loginregisterexample.Register;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginregisterexample.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText join_email, join_password, join_name, join_nickname, join_pwck;
    private Button join_button, check_button;
    private AlertDialog dialog;
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState);

        setContentView( R.layout.signup);

        // 아이디 값 찾아주기 - 이름, 닉네임, 이메일, 비밀번호, 비밀번호 확인
        join_name = findViewById( R.id.et_id);
        join_nickname = findViewById( R.id.et_nickname);
        join_email = findViewById(R.id.et_email);
        join_password = findViewById(R.id.et_pass);
        join_pwck = findViewById(R.id.et_confirmpass);

//        System.out.println(join_name);
//        System.out.println(join_nickname);
//        System.out.println(join_email);
//        System.out.println(join_password);
//        System.out.println(join_pwck);

        // 아이디 중복 체크
//        check_button = findViewById(R.id.)




    }




}
