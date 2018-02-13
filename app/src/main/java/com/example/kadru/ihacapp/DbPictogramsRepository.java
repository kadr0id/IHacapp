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
            cur = db.rawQuery("select objects.pictogram, object_lang.name from objects_locations inner join object_lang on objects_locations.object_id = object_lang._id inner join objects on  object_lang._id = objects._id where objects_locations.location_id =1 and object_lang.language =1 and objects.active =1 and objects.wholesaler_id is null;", null);
        }
        if (MainActivity.typeId == 18){
            cur = db.rawQuery("select objects.pictogram, object_lang.name from objects_locations inner join object_lang on objects_locations.object_id = object_lang._id inner join objects on  object_lang._id = objects._id where objects_locations.location_id =18 and object_lang.language =1 and objects.active =1 and objects.wholesaler_id is null;", null);
        }
        if (MainActivity.typeId == 19){
            cur = db.rawQuery("select objects.pictogram, object_lang.name from objects_locations inner join object_lang on objects_locations.object_id = object_lang._id inner join objects on  object_lang._id = objects._id where objects_locations.location_id =19 and object_lang.language =1 and objects.active =1 and objects.wholesaler_id is null;", null);
        }
        if (MainActivity.typeId == 20){
            cur = db.rawQuery("select objects.pictogram, object_lang.name from objects_locations inner join object_lang on objects_locations.object_id = object_lang._id inner join objects on  object_lang._id = objects._id where objects_locations.location_id =20 and object_lang.language =1 and objects.active =1 and objects.wholesaler_id is null;", null);
        }
        if (MainActivity.typeId == 21){
            cur = db.rawQuery("select objects.pictogram, object_lang.name from objects_locations inner join object_lang on objects_locations.object_id = object_lang._id inner join objects on  object_lang._id = objects._id where objects_locations.location_id =21 and object_lang.language =1 and objects.active =1 and objects.wholesaler_id is null;", null);
        }
        if (MainActivity.typeId == 22){
            cur = db.rawQuery("select objects.pictogram, object_lang.name from objects_locations inner join object_lang on objects_locations.object_id = object_lang._id inner join objects on  object_lang._id = objects._id where objects_locations.location_id =22 and object_lang.language =1 and objects.active =1 and objects.wholesaler_id is null;", null);
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