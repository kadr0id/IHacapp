package com.example.kadru.ihacapp;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DbObjectsRepository {
    private SQLiteDatabase db;
    private Context cont;

    public DbObjectsRepository(Context context) {
        db = new DbHelper(context).getWritableDatabase();
        cont = context;
    }
    public ArrayList<String> getData(){
        ArrayList<String> locations = new ArrayList<>();
        Cursor cur = db.rawQuery("select * from objects where wholesaler_id is not null and active =1 and type_id = 18", null);
        if (cur != null && cur.moveToFirst()) {
            do {
                locations.add(cur.getString(cur.getColumnIndexOrThrow("name")));
            } while (cur.moveToNext());
            if (cur != null) {
                cur.close();
            }
            db.close();
        }

        return locations;
    }

}
