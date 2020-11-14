package com.example.loginregisterexample.main_category;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.loginregisterexample.MainActivity;
import com.example.loginregisterexample.R;
//import com.example.loginregisterexample.viewpager.CategoryListActivity;

import java.util.ArrayList;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ItemViewHolder>{

    private ArrayList<MainCategoryData> listData = new ArrayList<>();
    private String genre = null;
    private String[] array = null;

    MainRecyclerAdapter(ArrayList<MainCategoryData> arrayList, String genre, String[] array) {
        listData = arrayList;
        this.genre = genre;
        this.array = array;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_category_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position));

        holder.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // 클릭해서 카테고리 리스트로 가는 함수
                /*Intent intent = new Intent(v.getContext(),CategoryListActivity.class);
                intent.putExtra("genre",genre);
                intent.putExtra("category",array[position*2]);
                v.getContext().startActivity(intent);*/
            }
        });
        if(holder.imageView2.isClickable() == true) {
            holder.imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // 클릭해서 카테고리 리스트로 가는 함수
                    /*Intent intent = new Intent(v.getContext(), CategoryListActivity.class);
                    intent.putExtra("genre", genre);
                    intent.putExtra("category", array[position * 2 + 1]);
                    Log.d(genre, array[position * 2 + 1]);
                    v.getContext().startActivity(intent);*/
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    void addItem(MainCategoryData data) {
        listData.add(data);
    }


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
}
