package com.example.loginregisterexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway);

        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.photoView);
        imageView.setImage(ImageSource.resource(R.drawable.img_subway));
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);

        Cursor c = null;
        SubwayDatabaseHelper myDbHelper = new SubwayDatabaseHelper(MainActivity.this); // Reading SQLite database.

        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        c = myDbHelper.query("subwayData", null, null, null, null, null, null); // SQLDataRead

        Cursor finalC = c;
        final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                Log.d("test","test");
                return super.onDown(e);
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.d("click","onSingleTapUp");
                if(imageView.isReady()) {
                    PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                    int x_cor = (int) sCoord.x;
                    int y_cor = (int) sCoord.y;
                    Log.d("click",x_cor+" "+y_cor);
                    if(finalC.moveToFirst()) {
                        do{
                            if((x_cor > finalC.getInt(2)) && (x_cor< finalC.getInt(4)) && (y_cor> finalC.getInt(3)) && (y_cor< finalC.getInt(5))) {
                                String targetStation = finalC.getString(1);
                                Log.d("click",targetStation);
                            }
                        }while (finalC.moveToNext());
                    }
                }
                return super.onSingleTapUp(e);
            }
        });
        /*PhotoView photoView = findViewById(R.id.photoView);
        photoView.setImageResource(R.drawable.img_subway);
        photoView.setMaximumScale(8);

        photoView.post(new Runnable() {
            @Override
            public void run() {
                photoView.setScale(3,true);
            }
        });*/
    }
}