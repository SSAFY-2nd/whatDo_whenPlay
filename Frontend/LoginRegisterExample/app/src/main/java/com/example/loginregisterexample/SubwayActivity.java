package com.example.loginregisterexample;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SubwayActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private TextView gestureText;
    private GestureDetector gDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway);

        /*Cursor c = null;
        SubwayDatabaseHelper myDbHelper = new SubwayDatabaseHelper(MainActivity.this);
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
        c = myDbHelper.query("subwayData", null, null, null, null, null, null); // SQLDataRead*/
        /*final SubsamplingScaleImageView imageView = (SubsamplingScaleImageView) findViewById(R.id.photoView); // 지하철역 이미지뷰
        imageView.setImage(ImageSource.resource(R.drawable.img_subway));*/

        this.gDetector = new GestureDetector(this,this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gDetector.onTouchEvent(event);
        // 오버라이딩한 슈퍼 클래스의 메서드를 호출한다.
        Log.i("tag","onTouchEvent");
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
    }
}