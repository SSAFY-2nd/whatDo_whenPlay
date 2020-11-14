package com.example.loginregisterexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        //view = inflater.inflate(R.layout.foodcategory,container,false);
        view = inflater.inflate(R.layout.activity_subway,container,false);
        MainActivity.selectedFrag = 1;
        return view;
    }



}
