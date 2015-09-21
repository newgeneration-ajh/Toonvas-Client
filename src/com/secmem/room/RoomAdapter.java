package com.secmem.room;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.secmem.spentest2.R;

public class RoomAdapter extends ArrayAdapter<RoomData> {

    private ArrayList<RoomData> items;

    public RoomAdapter(Context context, int textViewResourceId, ArrayList<RoomData> items) {
            super(context, textViewResourceId, items);
            this.items = items;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.item_list_room, null);
            }
            RoomData p = items.get(position);
            if (p != null) {
                    TextView title = (TextView) v.findViewById(R.id.tv_title);
                    
                    title.setText(p.getmRoomTitle());
                    
            }
            return v;
    }
    
    public void insertItem ( RoomData inData ) {
    	items.add(inData);
    	
    	this.notifyDataSetChanged();
    }
    
    public void deleteItem ( RoomData inData ) {
    	items.remove(inData);
    	this.notifyDataSetChanged();
    }
 
    
}