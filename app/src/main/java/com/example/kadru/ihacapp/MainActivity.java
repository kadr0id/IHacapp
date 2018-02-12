package com.example.kadru.ihacapp;


import android.content.Context;
import android.content.Intent;
import android.database.SQLException;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;


import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static int typeId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DbHelper helper = new DbHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Error Initialization Data Base");
        }
        try {
            helper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        ListView locations_item = (ListView) findViewById(R.id.locations_item);
        final DbRepository repository = new DbRepository(this.getApplicationContext());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, repository.getData());
        locations_item.setAdapter(adapter);


        locations_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Log.d(TAG, "itemClick: position = " + position + ", id = "
                        + id);
                    objects_res();

                if (id == 0)
                    typeId = 1;
                else if (id == 1)
                    typeId = 18;
                else if (id == 2)
                    typeId = 19;
                else if (id == 3)
                    typeId = 20;
                else if (id == 4)
                    typeId = 20;
                else if (id == 5)
                    typeId = 21;
                else if (id == 6)
                    typeId = 22;
            }
        });


        locations_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.d(TAG, "itemSelect: position = " + position + ", id = "
                        + id);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(TAG, "itemSelect: nothing");
            }
        });
    }



    public void objects_res() {
        ListView location_item = (ListView) findViewById(R.id.locations_item);
        final DbObjectsRepository repository = new DbObjectsRepository(this.getApplicationContext());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, repository.getData());
        location_item.setAdapter(adapter);
    }


    // public void image_res() {
    //    ImageView image_item = (ImageView) findViewById(R.id.image_item);
    //  final DbPictogramsRepository dbPictogramsRepository= new DbPictogramsRepository(this.getApplicationContext());
    // image_item.setImageURI(Uri.fromFile(new File("file:///android_asset/image/icons/Vloer.gif")));
    //   image_item.setImageResource(R.drawable.ic_launcher_background);
    //  Picasso.with(this.getApplicationContext())
    //        .load("file:///android_asset/" + dbPictogramsRepository.getData().toString())
    //         .into(image_item);
    //  Log.d(TAG, "Picasso is running :" + dbPictogramsRepository.getData().toString());
    //  }
}