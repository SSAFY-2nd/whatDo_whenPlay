package com.example.loginregisterexample.main_category;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginregisterexample.LogIn.LoginActivity;
import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.R;
import com.example.loginregisterexample.viewpager.CategoryListActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ItemViewHolder>{

    private ArrayList<MainCategoryData> listData = new ArrayList<>();
    private String genre = null;
    private String[] array = null;
    private String curId = null;
    private ArrayList<String> mData = null;

    static RequestQueue LoginQueue;
    static private ArrayList<Integer> curPlayState = new ArrayList<>();
    static private ArrayList<Integer> curFoodState = new ArrayList<>();


    MainRecyclerAdapter(ArrayList<MainCategoryData> arrayList, String genre, String[] array, String curId) {
        listData = arrayList;
        this.genre = genre;
        this.array = array;
        this.curId = curId;
    }

    //해당 adapter와 연결하는 recyclerView에 추가할 item의 레이아웃과 item Data를 bind
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_category_list, parent, false);
        // LoginQueue 객체생성
        LoginQueue = Volley.newRequestQueue(parent.getContext());

        return new ItemViewHolder(view);
    }

    //recyclerView 자체와 item 데이터셋을 서로 연결
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        holder.onBind(listData.get(position));
        ItemViewHolder itemviewholder = (ItemViewHolder) holder;

        holder.imageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.v("clickTest-1", Integer.toString(holder.getAdapterPosition()));


                Log.v("장르",genre);
                if(genre.equals("먹거리")){
                    Log.v("테스트", array[2*holder.getAdapterPosition()]);
                    holder.imageView1.setBackgroundColor(Color.parseColor("#afe3ff"));
                }else if(genre.equals("놀거리")){
                    Log.v("테스트", array[2*holder.getAdapterPosition()]);
                }

                // 클릭할 때
                //holder.imageView1.setBackgroundColor();

                // 클릭해서 카테고리 리스트로 가는 함수
//                Intent intent = new Intent(v.getContext(),CategoryListActivity.class);
//                intent.putExtra("genre",genre);
//                intent.putExtra("category",array[position*2]);
//                v.getContext().startActivity(intent);
            }
        });
        if(holder.imageView2.isClickable() == true) {
            holder.imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.v("clickTest-2", Integer.toString(holder.getAdapterPosition()));
                    Log.v("장르",genre);


                    Log.v("장르",genre);
                    if(genre.equals("먹거리")){
                        Log.v("테스트", array[2*holder.getAdapterPosition()+1]);
                    }else if(genre.equals("놀거리")){
                        Log.v("테스트", array[2*holder.getAdapterPosition()+1]);
                    }
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



        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            //button = itemView.findViewById(R.id.item_button);
            imageView1 = itemView.findViewById(R.id.item_imageview1);
            imageView2 = itemView.findViewById(R.id.item_imageview2);
        }

        void onBind(MainCategoryData data) {
            // GET 요청 ( /playtaste/{user_id} )
            getRequest();
            //button.setText(data);
            if(data.getImage1() != null)
                imageView1.setImageResource(data.getImage1());
            if(data.getImage2() != null)
                imageView2.setImageResource(data.getImage2());
            else {
                imageView2.setClickable(false);
                imageView2.setImageBitmap(null);
            }
        }
    }

    private void getRequest(){

        // 놀거리
        String URL = String.format("http://k3a304.p.ssafy.io:8399/playtaste/%d", Integer.parseInt(curId));
        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for(int i=0; i<jsonArray.length(); i++){
                                curPlayState.add(Integer.parseInt(jsonArray.get(i).toString()));
                            }
                            Log.v("tes22t",curPlayState.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                return;

            }
        }
        );

        // 캐쉬기능을 끊다. 바로바로 내용처리되도록
        request.setShouldCache(false);
        LoginQueue.add(request);

        // 음식
        URL = String.format("http://k3a304.p.ssafy.io:8399/foodtaste/%d", Integer.parseInt(curId));
        Log.v("URL_체크",URL);

        StringRequest foodRequest = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for(int i=0; i<jsonArray.length(); i++){
                                curFoodState.add(Integer.parseInt(jsonArray.get(i).toString()));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                return;

            }
        }
        );

        // 캐쉬기능을 끊다. 바로바로 내용처리되도록
        request.setShouldCache(false);
        LoginQueue.add(request);
        Log.v("TEST", curFoodState.toString());
        Log.v("TEST", curPlayState.toString());

        
    }
}
