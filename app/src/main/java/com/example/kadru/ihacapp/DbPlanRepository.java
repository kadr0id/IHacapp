package com.example.kadru.ihacapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbPlanRepository {
    private SQLiteDatabase db;
    private Context cont;
    Cursor cur;
    public DbPlanRepository(Context context) {
        db = new DbHelper(context).getWritableDatabase();
        cont = context;
    }



}