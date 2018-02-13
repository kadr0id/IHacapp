package com.example.kadru.ihacapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

public class ObjectActivity extends AppCompatActivity {
    public static ListView object_item;
    String imageForPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

        object_item = (ListView) findViewById(R.id.object_item);
        final DbObjectsRepository repository = new DbObjectsRepository(this.getApplicationContext());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, repository.getData());
        object_item.setAdapter(adapter);




            ImageView image_item = (ImageView) findViewById(R.id.image_item);
             final DbPictogramsRepository dbPictogramsRepository= new DbPictogramsRepository(this.getApplicationContext());
        Picasso.with(this)
                .load("file:///android_asset/" + imageForPicasso)
                .error(R.mipmap.ic_launcher)
                .into(image_item);
        imageForPicasso = dbPictogramsRepository.getData().toString();

    }

}
