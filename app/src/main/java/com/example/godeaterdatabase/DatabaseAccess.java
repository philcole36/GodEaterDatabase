package com.example.godeaterdatabase;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DatabaseAccess extends Application {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DataBaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<AragamiData> getData() {
        List<AragamiData> DataList = new ArrayList<>();
        AragamiData data;
        Cursor cursor = database.rawQuery("SELECT * FROM Aragami", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            data = new AragamiData(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), R.drawable.orgetail);


            Log.d(TAG, "getData: Cursor Image:" + cursor.getInt(4));
            Log.d(TAG, "getData: Cursor Image:" + cursor.getString(4));
            DataList.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        return DataList;
    }
}

