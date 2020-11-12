package com.example.loginregisterexample;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.loginregisterexample.Playwithme.Frag2;
import com.example.loginregisterexample.main_category.Frag0;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag0 frag0;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;

    public static Context mContext;

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
        frag3=new Frag3();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setFrag(0); // 첫 프래그먼트 화면 지정

        // 로그인 성공시 역검색 화면으로 넘어가며, Home 화면에는 로그인된 아이디를 띄워준다.


    }



    private SubsamplingScaleImageView imageView;

    public void SetSearchSubway() {
        imageView = (SubsamplingScaleImageView) findViewById(R.id.photoView);
        imageView.setImage(ImageSource.resource(R.drawable.img_subway));
    }
    public void InitializeView()
    {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
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
                        break;
                    case R.id.tab2:
                        setFrag(1);
                        SetSearchSubway();
                        break;
                    case R.id.tab3:
                        setFrag(2);
                        break;
                    case R.id.tab4:
                        setFrag(3);
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

            case 3:
                ft.replace(R.id.main_frame, frag3);
                ft.commitNow();
                break;
        }
    }
}