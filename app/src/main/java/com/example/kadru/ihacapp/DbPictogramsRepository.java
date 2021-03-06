package com.example.kadru.ihacapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DbPictogramsRepository {
    private SQLiteDatabase db;
    public Context cont;
    Cursor cur;


    public DbPictogramsRepository(Context context) {
        db = new DbHelper(context).getWritableDatabase();
        cont = context;
    }

    public ArrayList<String> getData() {
        ArrayList<String> pictogtams = new ArrayList<>();
        if (MainActivity.typeId == 1) {
            cur = db.rawQuery("select * from objects where wholesaler_id is not null and active =1 and type_id = 1;", null);
        }
        if (MainActivity.typeId == 18) {
            cur = db.rawQuery("select * from objects where wholesaler_id is not null and active =1 and type_id = 18", null);
        }
        if (MainActivity.typeId == 19) {
            cur = db.rawQuery("select * from objects where wholesaler_id is not null and active =1 and type_id = 19", null);
        }
        if (MainActivity.typeId == 20) {
            cur = db.rawQuery("select * from objects where wholesaler_id is not null and active =1 and type_id = 20", null);
        }
        if (MainActivity.typeId == 21) {
            cur = db.rawQuery("select * from objects where wholesaler_id is not null and active =1 and type_id = 21", null);
        }
        if (MainActivity.typeId == 22) {
            cur = db.rawQuery("select * from objects where wholesaler_id is not null and active =1 and type_id = 22", null);
        }
        if (cur != null && cur.moveToFirst()) {
            do {
                pictogtams.add(cur.getString(cur.getColumnIndexOrThrow("pictogram")));
            } while (cur.moveToNext());
            if (cur != null) {
                cur.close();
            }
            db.close();
        }

        return pictogtams;
    }
}