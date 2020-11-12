package com.example.loginregisterexample.main_category;

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

import com.example.loginregisterexample.R;
import com.example.loginregisterexample.viewpager.CategoryListActivity;

import java.util.ArrayList;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ItemViewHolder>{

    private ArrayList<MainCategoryData> listData = new ArrayList<>();

    MainRecyclerAdapter(ArrayList<MainCategoryData> arrayList) {
        listData = arrayList;
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
            Log.d("data",""+data.getImage2());
            //button.setText(data);
            if(data.getImage1() != null)
                imageView1.setImageResource(data.getImage1());
            if(data.getImage2() != null)
                imageView2.setImageResource(data.getImage2());
        }
    }
}
