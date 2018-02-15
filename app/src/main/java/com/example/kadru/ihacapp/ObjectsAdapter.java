package com.example.kadru.ihacapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
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

    //number of list items
    @Override
    public int getCount() {
        return objectsItems.size();
    }

    //item by position
    @Override
    public Object getItem(int position) {
        return objectsItems.get(position);
    }

    //id by position
    @Override
    public long getItemId(int position) {
        return position;
    }

    //list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //use created but not used view
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder();
            ObjectItem objectItem = getObjectItem(position);
            //fill the View in the list item with data from the items: name, pictogtams
            viewHolder.name = ((TextView) convertView.findViewById(R.id.object_item));
            viewHolder.pictogram = (ImageView) convertView.findViewById(R.id.image_item);
            viewHolder.checkPlanItems = (CheckBox) convertView.findViewById(R.id.check_item);
            CheckBox checkPlanItems = (CheckBox) convertView.findViewById(R.id.check_item);
            // assign the handler to the checkbox
            checkPlanItems.setOnCheckedChangeListener(myCheckChangeList);
            // write position
            checkPlanItems.setTag(position);
            // fill out the data from the item: is checked or not
            checkPlanItems.setChecked(objectItem.plan);
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

    // item by item
    private ObjectItem getObjectItem(int position) {
        return ((ObjectItem) getItem(position));
    }


    private static class ViewHolder {
        TextView name;
        ImageView pictogram;
        CheckBox checkPlanItems;
    }

    // the contents of the cleaning plan
    List<ObjectItem> getPlan() {
        List<ObjectItem> plan = new ArrayList<ObjectItem>();
        for (ObjectItem item : objectsItems) {
            //if in the cleaning plan
            if (item.plan)
                plan.add(item);
        }
        return plan;
    }

    // handler for checkboxes
    CompoundButton.OnCheckedChangeListener myCheckChangeList = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
    // change the items data (in the cleaning plan or not)
            getObjectItem((Integer) buttonView.getTag()).plan = isChecked;
        }
    };
}