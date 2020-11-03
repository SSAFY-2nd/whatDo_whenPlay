package com.example.loginregisterexample;

import android.database.Cursor;
import android.database.SQLException;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.IOException;


public class SubwayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway);

        Cursor c = null;
        SubwayDatabaseHelper myDbHelper = new SubwayDatabaseHelper(SubwayActivity.this);
        try{
            myDbHelper.createDataBase();
        } catch (Exception e) {
            throw new Error ("Unable to create database");
        }
        try{
            myDbHelper.openDataBase();
        } catch (Exception e) {
            throw e;
        }

    }
}