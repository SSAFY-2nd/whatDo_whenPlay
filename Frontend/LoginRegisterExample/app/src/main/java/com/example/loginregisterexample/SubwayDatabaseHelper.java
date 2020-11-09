package com.example.loginregisterexample;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SubwayDatabaseHelper extends SQLiteOpenHelper {
    String DB_PATH = null;
    private static String DB_NAME = "database.db";   //SQL Lite 파일명 이름
    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public SubwayDatabaseHelper(Context context) {
        super(context, DB_NAME, null, 10);
        this.myContext = context;
        this.DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
        Log.e("Path 1", DB_PATH);
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        Log.d("test",dbExist+"");
        if (dbExist) {
        } else {
            Log.d("test","CopyDataBase");
            this.getReadableDatabase();
            copyDataBase();
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            checkDB = null;
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase()  {
        InputStream myInput = null;
        try {
            myInput = myContext.getAssets().open(DB_NAME);
        } catch (IOException e) {
            Log.d("test","myInput");
            e.printStackTrace();
        }

        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = null;
        try {
            myOutput = new FileOutputStream(outFileName);
        } catch (FileNotFoundException e) {
            Log.d("test","myOutput");
            e.printStackTrace();
        }
        byte[] buffer = new byte[1024];
        int length;
        try {
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (Exception e) {
            Log.d("test","other");
        }
        Log.d("test","잘됨");
    }

    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
                copyDataBase();
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return myDataBase.query("subwayData", null, null, null, null, null, null);
    }
}
