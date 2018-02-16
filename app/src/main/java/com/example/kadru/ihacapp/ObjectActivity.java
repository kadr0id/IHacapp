package com.example.kadru.ihacapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


import java.util.List;

public class ObjectActivity extends AppCompatActivity {
    public static ListView object_items;
    ObjectsAdapter objectsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

       final DbObjectsRepository repository = new DbObjectsRepository(this.getApplicationContext());


        List<ObjectItem> objectItems = repository.getData();
        objectsAdapter = new ObjectsAdapter(this, objectItems);
        object_items = (ListView) findViewById(R.id.object_items);
        object_items.setAdapter(objectsAdapter);
    }
    public void showPlan(View v) {
        final DbPlanRepository dbPlanRepository = new DbPlanRepository(this.getApplicationContext());
        String result = "Plan items: ";
        for (ObjectItem object : objectsAdapter.getPlan()){
            if(object.plan)
                result += "\n" + object.name;
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
      //  dbPlanRepository.putData();
    }

}
