package com.example.kadru.ihacapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ObjectsAdapter extends BaseAdapter {

    private Context ctx;
    private LayoutInflater inflater;
    private List<ObjectItem> objectsItems;

    ObjectsAdapter(Context context, List<ObjectItem> objectsItem) {
        ctx = context;
        objectsItems = objectsItem;
        inflater = (LayoutInflater) ctx
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.name = ((TextView) convertView.findViewById(R.id.object_item));
            viewHolder.pictogram = (ImageView) convertView.findViewById(R.id.image_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ObjectItem objectItem = getObjectItem(position);
        viewHolder.name.setText(objectItem.name);
        String image = objectItem.image;
        Picasso.with(ctx)
                .load("file:///android_asset/" + image)
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.pictogram);
        return convertView;
    }

    private ObjectItem getObjectItem(int position) {
        return ((ObjectItem) getItem(position));
    }

    private static class ViewHolder {
        TextView name;
        ImageView pictogram;
    }
}