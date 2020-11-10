package com.example.loginregisterexample.viewpager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.loginregisterexample.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryListActivity extends AppCompatActivity {
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<String> foodNameList;
    private ArrayList<String> playNameList;

    private ArrayList<ArrayList<SampleData>> categoryList;
    private int selectedPosition = 0;
    private static final int DP = 24;

    private TextView foodButton;
    private TextView playButton;

    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorylist_activity);

        this.initializeData();

        // two button
        foodButton = findViewById(R.id.categoryFoodButton);
        playButton = findViewById(R.id.categoryPlayButton);
        if(selectedPosition == 0) {
            foodButton.setBackgroundResource(R.drawable.food_play_ripple_effect_click);
            playButton.setBackgroundResource(R.drawable.food_play_ripple_effect);
        } else {
            foodButton.setBackgroundResource(R.drawable.food_play_ripple_effect);
            playButton.setBackgroundResource(R.drawable.food_play_ripple_effect_click);
        }
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = 0;
                selectButton();
                recyclerAdapter = new RecyclerAdapter(foodNameList);
                recyclerView.setAdapter(recyclerAdapter);
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectedPosition = 1;
                selectButton();
                recyclerAdapter = new RecyclerAdapter(playNameList);
                recyclerView.setAdapter(recyclerAdapter);
            }
        });


        // button list
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView = findViewById(R.id.buttonListView);
        recyclerView.setLayoutManager(linearLayoutManager);


        recyclerAdapter = new RecyclerAdapter(foodNameList);
        recyclerView.setAdapter(recyclerAdapter);

        // list viewPager
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(this, categoryList));

        //viewPager.setClipToPadding(false);
        /*float density = getResources().getDisplayMetrics().density;
        int margin = (int) (DP * density);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);*/
    }
    public void selectButton() {
        if(selectedPosition == 0) {
            foodButton.setBackgroundResource(R.drawable.food_play_ripple_effect_click);
            playButton.setBackgroundResource(R.drawable.food_play_ripple_effect);
        } else {
            foodButton.setBackgroundResource(R.drawable.food_play_ripple_effect);
            playButton.setBackgroundResource(R.drawable.food_play_ripple_effect_click);
        }
    }
    public void initializeData()
    {
        foodNameList = new ArrayList<>();
        foodNameList.add("전체");
        foodNameList.add("한식");
        foodNameList.add("피자/양식");
        foodNameList.add("분식");
        foodNameList.add("카페/디저트");
        foodNameList.add("일식/돈까스");
        foodNameList.add("중국집");
        foodNameList.add("치킨");
        foodNameList.add("족발/보쌈");
        playNameList = new ArrayList<>();
        playNameList.add("전체");
        playNameList.add("노래방");
        playNameList.add("방탈출");
        playNameList.add("당구장");
        playNameList.add("PC방");
        playNameList.add("박물관");

        categoryList = new ArrayList<ArrayList<SampleData>>();

        for (int i=0; i<5; i++) {
            ArrayList<SampleData> temp = new ArrayList<>();
            temp.add(new SampleData(R.drawable.user_icon, "미션임파서블","15세 이상관람가"));
            temp.add(new SampleData(R.drawable.user_icon, "아저씨","19세 이상관람가"));
            temp.add(new SampleData(R.drawable.user_icon, "어벤져스","12세 이상관람가"));
            categoryList.add(temp);
        }

    }
}
