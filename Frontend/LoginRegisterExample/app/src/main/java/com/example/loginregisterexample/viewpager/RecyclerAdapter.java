package com.example.loginregisterexample.viewpager;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregisterexample.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>{

    private ArrayList<String> listData = new ArrayList<>();
    private int selectedPosition = 0;

    RecyclerAdapter(ArrayList<String> arrayList) {
        listData = arrayList;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorylist_button, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        if(selectedPosition == position) {
            holder.textView.setBackgroundResource(R.drawable.custom_ripple_effect_border);

            holder.textView.setTextColor(Color.RED);
        } else {
            holder.textView.setBackgroundResource(R.drawable.custom_ripple_effect);
            holder.textView.setTextColor(Color.BLACK);
        }
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = position;
                for (int i=0; i<getItemCount(); ++i)
                    notifyItemChanged(i);
            }

        });
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    void addItem(String data) {
        listData.add(data);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        //private Button button;
        private TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            //button = itemView.findViewById(R.id.item_button);
            textView = itemView.findViewById(R.id.item_textview);
        }

        void onBind(String data) {
            //button.setText(data);
            textView.setText(data);
        }
    }
}
