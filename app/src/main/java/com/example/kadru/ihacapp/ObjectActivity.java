package com.example.kadru.ihacapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ObjectActivity extends AppCompatActivity {
    public static ListView object_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

        object_item = (ListView) findViewById(R.id.object_item);
        final DbObjectsRepository repository = new DbObjectsRepository(this.getApplicationContext());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, repository.getData());
        object_item.setAdapter(adapter);


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

}
