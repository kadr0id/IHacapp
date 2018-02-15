package com.example.kadru.ihacapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DbPlanRepository {


    List <String> argsItems;


    private SQLiteDatabase db;
    private Context cont;
    Cursor cur;
    public static ListView object_items;


    public DbPlanRepository(Context context) {
        db = new DbHelper(context).getWritableDatabase();
        cont = context;
    }
    //   ObjectsAdapter objectsAdapter = new ObjectsAdapter(this, );
//    public void savePlan(View v) {
//
//    }
//
//    public void putData (List<String> argsItems) {
//        ContentValues cv = new ContentValues();
//         db.rawQuery("create table cleaning_plan (_id)",  null);
//        for (ObjectItem object : objectsAdapter.getPlan()) {
//            if (object.plan)
//              //  cv.put(object.name);
//            db.insert("cleaning_plan", null, cv );
//        }
//        db.close();
//    }

}