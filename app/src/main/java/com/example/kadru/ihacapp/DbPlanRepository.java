package com.example.kadru.ihacapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class DbPlanRepository {


    ObjectsAdapter adapter;


    private SQLiteDatabase db;
    private Context cont;



    public DbPlanRepository(Context context) {
        db = new DbHelper(context).getWritableDatabase();
        cont = context;
    }


    public void putData () {
        ContentValues cv = new ContentValues();
         db.rawQuery("create table cleaning_plan (_id, name)",  null);
        for (ObjectItem object : adapter.getPlan()) {
            if (object.plan)
                cv.put("_id", object.name);
        }
        for (int i=0; i < cv.size(); i++ ) {
            db.insert("cleaning_plan", null, cv);
        }
        db.close();
    }

}