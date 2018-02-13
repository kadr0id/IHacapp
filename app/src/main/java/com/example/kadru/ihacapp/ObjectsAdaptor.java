package com.example.kadru.ihacapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ObjectsAdaptor extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<ObjectItem> objectsItems;

    ObjectsAdaptor(Context context, ArrayList<ObjectItem> objectsItem) {
        ctx = context;
        objectsItems = objectsItem;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return objectsItems.size();
    }

    @Override
    public Object getItem(int position) {
        return objectsItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        ObjectItem objectItem = getObjectItem(position);
        ((TextView) view.findViewById(R.id.object_item)).setText(objectItem.name);
         ((ImageView) view.findViewById(R.id.image_item)).setImageResource(objectItem.image);

        return view;
    }


    ObjectItem getObjectItem(int position) {
        return ((ObjectItem) getItem(position));
    }
}