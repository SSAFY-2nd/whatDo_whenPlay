package com.example.loginregisterexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.ls.LSOutput;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag0 frag0;
    private Frag1 frag1;
    private Frag2 frag2;
//    private Frag3 frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

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
//                        System.out.println("before_setFrag(1)");
                        setFrag(1);
//                        System.out.println("after_setFrag(1)");
                        break;
                    case R.id.tab3:
//                        System.out.println("before_setFrag(2)");
                        setFrag(2);
//                        System.out.println("after_setFrag(2)");
                        break;
                }
                return true;
            }
        });
        frag0=new Frag0();
//        System.out.println("BB");
        frag1=new Frag1();
//        System.out.println("CC");
        frag2=new Frag2();
//        frag3=new Frag3();
        setFrag(0); // 첫 프래그먼트 화면 지정

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
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;

            case 2:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;


        }

    }
}