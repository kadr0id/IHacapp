package com.example.kadru.ihacapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ObjectActivity extends AppCompatActivity {
    public static ListView object_item;
    ArrayList<String> imageForPicasso = new ArrayList<>();
    ArrayList<ObjectItem> objectItems = new ArrayList<ObjectItem>();
    ObjectsAdaptor objectsAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

  //      fillData();
        objectsAdaptor = new ObjectsAdaptor(this, objectItems);
        object_item = (ListView) findViewById(R.id.object_item);
        object_item.setAdapter(objectsAdaptor);

//        object_item = (ListView) findViewById(R.id.object_item);
       final DbObjectsRepository repository = new DbObjectsRepository(this.getApplicationContext());
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, repository.getData());
//        object_item.setAdapter(adapter);


        //  ImageView image_item = (ImageView) findViewById(R.id.image_item);
        // final DbPictogramsRepository dbPictogramsRepository = new DbPictogramsRepository(this.getApplicationContext());
        // ArrayAdapter<String> imAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, repository.getData());
//        Picasso.with(this)
//                .load("file:///android_asset/" + imageForPicasso.get(0))
//                .error(R.mipmap.ic_launcher)
//                .into(image_item);
        //  imageForPicasso.addAll(imAdapter);
        // imageForPicasso = dbPictogramsRepository.getData().toString();

    }
//    void fillData() {
//        for (int i = 1; i <= 20; i++) {
//            objectItems.add(new ObjectItem(,
//                    ));
//        }
//    }

}
