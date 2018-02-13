package com.example.kadru.ihacapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.List;

public class ObjectActivity extends AppCompatActivity {
    public static ListView object_item;
    ObjectsAdapter objectsAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);


       final DbObjectsRepository repository = new DbObjectsRepository(this.getApplicationContext());


        List<ObjectItem> objectItems = repository.getData();
        objectsAdaptor = new ObjectsAdapter(this, objectItems);
        object_item = (ListView) findViewById(R.id.object_item);
        object_item.setAdapter(objectsAdaptor);

    }
}
