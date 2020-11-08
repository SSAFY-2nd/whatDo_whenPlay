package com.example.loginregisterexample;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.github.chrisbanes.photoview.PhotoView;


public class SubwayActivity extends AppCompatActivity /*implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener*/{
    private TextView gestureText;
    private GestureDetector gDetector;
    private Cursor c;
    public static Context mContext;
    private SubsamplingScaleImageView imageView;

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("resume","resume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway);
        mContext = this;

        imageView = (SubsamplingScaleImageView) findViewById(R.id.photoView);
        imageView.setImage(ImageSource.resource(R.drawable.img_subway));


        c = null;
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
        c = myDbHelper.query("subwayData", null, null, null, null, null, null); // SQLDataRead

        //this.gDetector = new GestureDetector(this,this);
    }

/*    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        //gestureText.setText("onSingleTapConfirmed");
        Log.i("tag","onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        //gestureText.setText("onDoubleTap");
        Log.i("tag","onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        //gestureText.setText("onDoubleTapEvent");
        Log.i("tag","onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        //gestureText.setText("onDown");
        Log.i("tag","onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        //gestureText.setText("onShowPress");
        Log.i("tag","onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        //gestureText.setText("onSingleTapUp");
        Log.i("tag","onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        //gestureText.setText("onScroll");
        Log.i("tag","onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        //gestureText.setText("onLongPress");
        Log.i("tag","onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        //gestureText.setText("onFling");
        Log.i("tag","onFling");
        return true;
    }*/
}