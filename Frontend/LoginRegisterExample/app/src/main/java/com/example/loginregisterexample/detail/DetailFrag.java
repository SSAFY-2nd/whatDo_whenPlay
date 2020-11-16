package com.example.loginregisterexample.detail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.loginregisterexample.R;

import org.w3c.dom.Text;

public class DetailFrag extends Fragment {
    private View view;
    private ImageView store_picture;
    private TextView store_name;
    private TextView store_rating;
    private TextView store_review;
    private TextView store_phoneNumber;
    private TextView store_address;
    private TextView store_workingTime;
    private TextView store_menu;
    private TextView store_introduce;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.detail,container,false);
        store_picture = view.findViewById(R.id.store_picture);
        store_name = view.findViewById(R.id.store_name);
        store_rating = view.findViewById(R.id.store_rating);
        store_review = view.findViewById(R.id.store_review);
        store_phoneNumber = view.findViewById(R.id.store_phoneNumber);
        store_address = view.findViewById(R.id.store_address);
        store_workingTime = view.findViewById(R.id.store_workingTime);
        store_menu = view.findViewById(R.id.store_menu);
        store_introduce = view.findViewById(R.id.store_introduce);

        Bundle bundle = getArguments();
        Glide.with(view.getContext()).load(bundle.getString("store_picture")).into(store_picture);
        store_name.setText(bundle.getString("store_name"));
        store_rating.setText(bundle.getString("store_rating"));
        store_review.setText(bundle.getString("store_review"));
        store_phoneNumber.setText(bundle.getString("store_phoneNumber"));
        store_address.setText(bundle.getString("store_address"));
        store_workingTime.setText(bundle.getString("store_workingTime"));
        String menu = bundle.getString("store_menu");
        Log.d("menu",menu);
        if(menu.equals("null")) {
            store_menu.setText("");
        } else {
            store_menu.setText(bundle.getString("store_menu"));
        }

        store_introduce.setText(bundle.getString("store_introduce"));


        return view;
    }
}
