package com.example.kadru.ihacapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;


public class DbRepository {
    private SQLiteDatabase db;
    private Context cont;

    public DbRepository(Context context) {
        db = new DbHelper(context).getWritableDatabase();
        cont = context;
    }
        public ArrayList<String> getData(){
        ArrayList<String> locations = new ArrayList<>();
        Cursor cur = db.rawQuery("select * from locations", null);
        if (cur != null && cur.moveToFirst()) {
            do {
                locations.add(cur.getString(cur.getColumnIndexOrThrow("type")));
            } while (cur.moveToNext());
            if (cur != null) {
                cur.close();
            }
            db.close();
        }

        return locations;
    }
}
