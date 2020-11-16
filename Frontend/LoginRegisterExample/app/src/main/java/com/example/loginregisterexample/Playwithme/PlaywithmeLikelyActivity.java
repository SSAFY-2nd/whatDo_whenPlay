package com.example.loginregisterexample.Playwithme;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.loginregisterexample.R;
import com.example.loginregisterexample.VO.foodCategory;
import com.example.loginregisterexample.VO.foodNameMap;
import com.example.loginregisterexample.VO.playCategory;
import com.example.loginregisterexample.VO.playNameMap;
import com.example.loginregisterexample.main_category.Frag0;

import java.util.ArrayList;
import java.util.HashMap;

public class PlaywithmeLikelyActivity extends AppCompatActivity {

    private View view;
    private ImageView eat_strongcomm1, eat_strongcomm2, eat_strongcomm3;
    private ImageView eat_comm1, eat_comm2, eat_comm3;
    private ImageView play_strongcomm1, play_strongcomm2, play_strongcomm3;
    private ImageView play_comm1, play_comm2, play_comm3;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView( R.layout.playwithme_likely);
        Intent intent = getIntent();

        ArrayList<Integer> listPlay = getIntent().getIntegerArrayListExtra("listplay");
        ArrayList<Integer> listFood = getIntent().getIntegerArrayListExtra("listfood");


        foodCategory fc = new foodCategory();
        playCategory pc = new playCategory();
        foodNameMap fnm = new foodNameMap();
        playNameMap pnm = new playNameMap();


        eat_strongcomm1 = (ImageView)findViewById(R.id.btn_eat_strongcomm1);
        eat_strongcomm2 = (ImageView)findViewById(R.id.btn_eat_strongcomm2);
        eat_strongcomm3 = (ImageView)findViewById(R.id.btn_eat_strongcomm3);

        eat_comm1 = (ImageView)findViewById(R.id.btn_eat_comm1);
        eat_comm2 = (ImageView)findViewById(R.id.btn_eat_comm2);
        eat_comm3 = (ImageView)findViewById(R.id.btn_eat_comm3);


        play_strongcomm1 = (ImageView)findViewById(R.id.btn_play_strongcomm1);
        play_strongcomm2 = (ImageView)findViewById(R.id.btn_play_strongcomm2);
        play_strongcomm3 = (ImageView)findViewById(R.id.btn_play_strongcomm3);


        play_comm1 = (ImageView)findViewById(R.id.btn_play_comm1);
        play_comm2 = (ImageView)findViewById(R.id.btn_play_comm2);
        play_comm3 = (ImageView)findViewById(R.id.btn_play_comm3);


        // 놀거리 강추 3, 추천 3, 먹거리 강추 3, 추천 3
        eat_strongcomm1.setImageDrawable(getResources().getDrawable(fnm.getFoodNameMap(fc.getFoodCategory(listFood.get(0)))));
        eat_strongcomm2.setImageDrawable(getResources().getDrawable(fnm.getFoodNameMap(fc.getFoodCategory(listFood.get(1)))));
        eat_strongcomm3.setImageDrawable(getResources().getDrawable(fnm.getFoodNameMap(fc.getFoodCategory(listFood.get(2)))));

        eat_comm1.setImageDrawable(getResources().getDrawable(fnm.getFoodNameMap(fc.getFoodCategory(listFood.get(4)))));
        eat_comm2.setImageDrawable(getResources().getDrawable(fnm.getFoodNameMap(fc.getFoodCategory(listFood.get(5)))));
        eat_comm3.setImageDrawable(getResources().getDrawable(fnm.getFoodNameMap(fc.getFoodCategory(listFood.get(6)))));

        play_strongcomm1.setImageDrawable(getResources().getDrawable(pnm.getPlayNameMap(pc.getPlayCategory(listPlay.get(0)))));
        play_strongcomm2.setImageDrawable(getResources().getDrawable(pnm.getPlayNameMap(pc.getPlayCategory(listPlay.get(1)))));
        play_strongcomm3.setImageDrawable(getResources().getDrawable(pnm.getPlayNameMap(pc.getPlayCategory(listPlay.get(2)))));

        play_comm1.setImageDrawable(getResources().getDrawable(pnm.getPlayNameMap(pc.getPlayCategory(listPlay.get(3)))));
        play_comm2.setImageDrawable(getResources().getDrawable(pnm.getPlayNameMap(pc.getPlayCategory(listPlay.get(4)))));
        play_comm3.setImageDrawable(getResources().getDrawable(pnm.getPlayNameMap(pc.getPlayCategory(listPlay.get(5)))));



    }


}
