package com.example.loginregisterexample;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.loginregisterexample.viewpager.CategoryListFrag;

//import com.example.loginregisterexample.viewpager.CategoryListActivity;

public class PopupActivity extends Activity {
    //private TextView textView;
    private Button subway_btn;
    private Button food_btn, play_btn, playwith_btn;

    @Override
    protected void onPause() {
        super.onPause();

        overridePendingTransition(0,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popup);
        //배경 투명
        getWindow().setBackgroundDrawable(new ColorDrawable(0));

        //UI 객체생성
        //textView = (TextView)findViewById(R.id.txtText);
        subway_btn = (Button)findViewById(R.id.subway_name_btn);

        //데이터 가져오기
        Intent intent = getIntent();
        String data = intent.getStringExtra("subway");
        //textView.setText(data);
        subway_btn.setText(data);

        play_btn = findViewById(R.id.subway_left);
        food_btn = findViewById(R.id.subway_right);
        playwith_btn = findViewById(R.id.subway_main_btn);

        food_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("화면",4);
                intent.putExtra("genre","먹거리");
                intent.putExtra("category","전체");
                v.getContext().startActivity(intent);
                //finish();
            }
        });
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("화면",4);
                intent.putExtra("genre","놀거리");
                intent.putExtra("category","전체");
                v.getContext().startActivity(intent);
                //finish();
            }
        });
        playwith_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("화면",2);
                String subway = getIntent().getStringExtra("subway");
                intent.putExtra("subway",subway);
                v.getContext().startActivity(intent);
                //finish();
            }
        });
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            return true;
        }
        if(event.getAction()==MotionEvent.ACTION_DOWN) {
            finish();
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(isFinishing()) {
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }
    }
}
