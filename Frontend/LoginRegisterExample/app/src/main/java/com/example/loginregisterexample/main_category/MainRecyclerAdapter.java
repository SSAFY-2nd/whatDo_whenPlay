package com.example.loginregisterexample.main_category;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginregisterexample.LogIn.LoginActivity;
import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.R;
import com.example.loginregisterexample.VO.foodCategory;
import com.example.loginregisterexample.VO.playCategory;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ItemViewHolder>{

    private ArrayList<MainCategoryData> listData = new ArrayList<>();
    private String genre = null;
    private String[] array = null;
    private String curId = null;
    private HashSet<String> foodData = new HashSet<String>();
    private HashSet<String> playData = new HashSet<String>();
//    public ArrayList<String> foodData = new ArrayList<String>();
//    public ArrayList<String> playData = new ArrayList<String>();
    private HashSet<Integer> foodIdxData = new HashSet<Integer>();
    private HashSet<Integer> playIdxData = new HashSet<Integer>();
    private ArrayList<Integer> idxData = new ArrayList<Integer>();


    private TextView tasteView;

    public HashSet<Integer> getIdxFoodData() {
        return foodIdxData;
    }

    public HashSet<Integer> getIdxPlayData() {
        return playIdxData;
    }

    public HashSet<String> getFoodData() {
        return foodData;
    }

    public HashSet<String> getPlayData() {
        return playData;
    }

    MainRecyclerAdapter(ArrayList<MainCategoryData> arrayList, String genre, String[] array, String curId, ArrayList<Integer> idxData) {
        listData = arrayList;
        this.genre = genre;
        this.array = array;
        this.curId = curId;
//        this.playIdxData = curPlayList;
//        this.foodIdxData = curFoodList;
        this.idxData = idxData;

    }



    //해당 adapter와 연결하는 recyclerView에 추가할 item의 레이아웃과 item Data를 bind
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_category_list, parent, false);

        return new ItemViewHolder(view);
    }

    //recyclerView 자체와 item 데이터셋을 서로 연결
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        holder.onBind(listData.get(position));
        ItemViewHolder itemviewholder = (ItemViewHolder) holder;

        // 호출하면 여기서 바탕색 변경하고, 취향 LIST에 글자로 표시


//        for(int i : foodIdxData){
//
//            // 해당 idx찾아서 한글로 변환해서 넣기.
//            foodCategory fc = new foodCategory();
//            foodData.add(fc.getFoodCategory(i));
//        }
//
//        for(int i : playIdxData){
//
//            playCategory pc = new playCategory();
//            playData.add(pc.getPlayCategory(i));
//        }


        if(genre.equals("놀거리")){
            for(int i : idxData){
                playIdxData.add(i);
                playCategory pc = new playCategory();
                playData.add(pc.getPlayCategory(i));
            }
        }else if(genre.equals("먹거리")){
            for(int i : idxData){
                foodIdxData.add(i);
                foodCategory pc = new foodCategory();
                foodData.add(pc.getFoodCategory(i));
            }
        }



        for(int i : idxData){

            if(( i - 1) / 2 == position){

                // 홀수
                if (( i % 2 == 1)) {

                    holder.imageView1.setBackgroundColor(Color.parseColor("#afe3ff"));
                }

                // 짝수
                if (( i % 2 == 0)) {
                    holder.imageView2.setBackgroundColor(Color.parseColor("#afe3ff"));
                }

            }

        }

//        Log.v("푸드 데이터", foodIdxData.toString());
//        Log.v("플레이 데이터", playIdxData.toString());
//        Log.v("푸드 데이터", foodData.toString());
//        Log.v("플레이 데이터", playData.toString());

//        for(int i : foodIdxData){
//
//            if(( i - 1) / 2 == position){
//
//                // 홀수
//                if (( i % 2 == 1)) {
//
//                    holder.imageView1.setBackgroundColor(Color.parseColor("#afe3ff"));
//                }
//
//                // 짝수
//                if (( i % 2 == 0)) {
//                    holder.imageView2.setBackgroundColor(Color.parseColor("#afe3ff"));
//                }
//
//            }
//
//        }
//
//        for(int i : playIdxData){
//
//            if(( i - 1) / 2 == position){
//
//                // 홀수
//                if (( i % 2 == 1)) {
//
//                    holder.imageView1.setBackgroundColor(Color.parseColor("#afe3ff"));
//                }
//
//                // 짝수
//                if (( i % 2 == 0)) {
//                    holder.imageView2.setBackgroundColor(Color.parseColor("#afe3ff"));
//                }
//
//            }
//
//        }


        // 첫째 줄
        holder.imageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.v("장르",genre);
                if(genre.equals("먹거리")){

                    Log.v("테스트", array[2*holder.getAdapterPosition()]);
                    // 만약 이미 리스트에 있다면 삭제와 무색으로 변경, 없다면 추가 및 색상 변경.
                    if(foodData.contains(array[2*holder.getAdapterPosition()])){
                        foodData.remove(array[2*holder.getAdapterPosition()]);
                        holder.imageView1.setBackgroundColor(Color.parseColor("#ffffff"));
                        Log.v("AA",Integer.toString(2*holder.getAdapterPosition()));
                        foodIdxData.remove(2*holder.getAdapterPosition()+1);
                    }else{
                        foodData.add(array[2*holder.getAdapterPosition()]);
                        holder.imageView1.setBackgroundColor(Color.parseColor("#afe3ff"));
                        Log.v("AA",Integer.toString(2*holder.getAdapterPosition()));
                        foodIdxData.add(2*holder.getAdapterPosition()+1);
                    }

                }else if(genre.equals("놀거리")){
                    Log.v("테스트", array[2*holder.getAdapterPosition()]);
                    if(playData.contains(array[2*holder.getAdapterPosition()])){
                        playData.remove(array[2*holder.getAdapterPosition()]);
                        holder.imageView1.setBackgroundColor(Color.parseColor("#ffffff"));
                        playIdxData.remove(2*holder.getAdapterPosition()+1);
                    }else{
                        playData.add(array[2*holder.getAdapterPosition()]);
                        holder.imageView1.setBackgroundColor(Color.parseColor("#afe3ff"));
                        playIdxData.add(2*holder.getAdapterPosition()+1);
                    }
                }

                Log.v("Result", foodData.toString());
                Log.v("Result2", playData.toString());
                // 클릭할 때
                //holder.imageView1.setBackgroundColor();

                // 클릭해서 카테고리 리스트로 가는 함수
//                Intent intent = new Intent(v.getContext(),CategoryListActivity.class);
//                intent.putExtra("genre",genre);
//                intent.putExtra("category",array[position*2]);
//                v.getContext().startActivity(intent);
            }
        });
        
        // 둘째 줄
        if(holder.imageView2.isClickable() == true) {
            holder.imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     Log.v("장르",genre);


                    Log.v("장르",genre);
                    if(genre.equals("먹거리")){
                        Log.v("테스트", array[2*holder.getAdapterPosition()+1]);
                        if(foodData.contains(array[2*holder.getAdapterPosition()+1])){
                            foodData.remove(array[2*holder.getAdapterPosition()+1]);
                            holder.imageView2.setBackgroundColor(Color.parseColor("#ffffff"));
//                            Log.v("먹거리",Integer.toString(2*holder.getAdapterPosition()+1));
                            foodIdxData.remove(2*holder.getAdapterPosition()+2);
                        }else{
                            foodData.add(array[2*holder.getAdapterPosition()+1]);
                            holder.imageView2.setBackgroundColor(Color.parseColor("#afe3ff"));
                            Log.v("먹거리",Integer.toString(2*holder.getAdapterPosition()+1));
                            foodIdxData.add(2*holder.getAdapterPosition()+2);
                        }
                    }else if(genre.equals("놀거리")){
                        Log.v("테스트", array[2*holder.getAdapterPosition()+1]);
                        if(playData.contains(array[2*holder.getAdapterPosition()+1])){
                            playData.remove(array[2*holder.getAdapterPosition()+1]);
                            holder.imageView2.setBackgroundColor(Color.parseColor("#ffffff"));
                            playIdxData.remove(2*holder.getAdapterPosition()+2);
                        }else{
                            playData.add(array[2*holder.getAdapterPosition()+1]);
                            holder.imageView2.setBackgroundColor(Color.parseColor("#afe3ff"));
                            playIdxData.add(2*holder.getAdapterPosition()+2);
                        }
                    }
                    Log.v("foodData", foodData.toString());
                    Log.v("playData", playData.toString());

                    // 클릭해서 카테고리 리스트로 가는 함수
//                    Intent intent = new Intent(v.getContext(), CategoryListActivity.class);
//                    intent.putExtra("genre", genre);
//                    intent.putExtra("category", array[position * 2 + 1]);
                    //Log.d(genre, array[position * 2 + 1]);
//                    v.getContext().startActivity(intent);
                }
            });

        }


    }

    //  데이터셋의 데이터 개수
    @Override
    public int getItemCount() {
        return listData.size();
    }

    void addItem(MainCategoryData data) {
        listData.add(data);
    }


    //item 레이아웃에 추가했던 view들을 추가하고, 생성자에서 id로 연결
    class ItemViewHolder extends RecyclerView.ViewHolder {
        //private Button button;
        private ImageView imageView1;
        private ImageView imageView2;

        private TextView textView1;
        private TextView textView2;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.v("CC","CC");
            //button = itemView.findViewById(R.id.item_button);
            imageView1 = itemView.findViewById(R.id.item_imageview1);
            imageView2 = itemView.findViewById(R.id.item_imageview2);
            textView1 = itemView.findViewById(R.id.item_textview1);
            textView2 = itemView.findViewById(R.id.item_textview2);


        }

        void onBind(MainCategoryData data) {
            // LoginQueue 객체생성


            // GET 요청 ( /playtaste/{user_id} )
            // 이 요청이 끝날때까지 기다리기.
            Log.v("BB","BB");


            //button.setText(data);
            if(data.getImage1() != null){
                imageView1.setImageResource(data.getImage1());
                textView1.setText(data.getText1());
            }
            else {
                imageView1.setClickable(false);
                imageView1.setImageBitmap(null);
            }
            if(data.getImage2() != null){
                imageView2.setImageResource(data.getImage2());
                textView2.setText(data.getText2());
            }
            else {
                imageView2.setClickable(false);
                imageView2.setImageBitmap(null);
                textView2.setText("");
            }

        }
    }


}
