package com.example.loginregisterexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag0 frag0;
    private Frag1 frag1;
    private Frag2 frag2;
//    private Frag3 frag3;

    public static Context mContext;

    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeView();
        SetListener();

        frag0=new Frag0();
        frag1=new Frag1();
        frag2=new Frag2();


    }

    @Override
    protected void onStart() {
        super.onStart();
        setFrag(0); // 첫 프래그먼트 화면 지정
        SetSignUp();
    }

    public void SetSignUp() {
        Log.d("test","main page");

        btn_register = (Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                //이곳에 버튼 클릭시 일어날 일을 적습니다.
                Log.d("test","signup click");
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });

    }

    private SubsamplingScaleImageView imageView;

    public void SetSearchSubway() {
        imageView = (SubsamplingScaleImageView) findViewById(R.id.photoView);
        imageView.setImage(ImageSource.resource(R.drawable.img_subway));
    }
    public void InitializeView()
    {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        btn_register = (Button)findViewById(R.id.btn_register);
    }
    public void SetListener()
    {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                System.out.println(menuItem);
                switch (menuItem.getItemId())
                {
                    case R.id.tab1:
                        setFrag(0);
                        SetSignUp();
                        break;
                    case R.id.tab2:
                        setFrag(1);
                        SetSearchSubway();
                        break;
                    case R.id.tab3:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });


    }

    // 프레그먼트 교체
    private void setFrag(int n)
    {
        fm = getSupportFragmentManager();
        ft= fm.beginTransaction();
        System.out.println(n);
        switch (n)
        {
            case 0:
                ft.replace(R.id.main_frame , frag0);
                ft.commitNow();
                break;

            case 1:
                ft.replace(R.id.main_frame, frag1);
                ft.commitNow();
                break;

            case 2:
                ft.replace(R.id.main_frame, frag2);
                ft.commitNow();
                break;


        }

    }
}