package com.secmem.room;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.secmem.spentest2.R;

public class WaitRoomAdapter extends ArrayAdapter<WaitRoomData> {

    private ArrayList<WaitRoomData> items;

    public WaitRoomAdapter(Context context, int textViewResourceId, ArrayList<WaitRoomData> items) {
            super(context, textViewResourceId, items);
            this.items = items;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.item_list_wait_room, null);
            }
            WaitRoomData p = items.get(position);
            if (p != null) {
                    TextView num = (TextView) v.findViewById(R.id.tv_title_wait);
                    
                    num.setText(p.joiner.toString());
                    
            }
            return v;
    }
    
    public void insertItem ( WaitRoomData inData ) {
    	items.add(inData);
    	
    	this.notifyDataSetChanged();
    }
    
    public void deleteItem ( WaitRoomData inData ) {
    	items.remove(inData);
    	this.notifyDataSetChanged();
    }
 
    
}