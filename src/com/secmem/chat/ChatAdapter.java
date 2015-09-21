package com.secmem.chat;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.secmem.spentest2.R;

public class ChatAdapter extends ArrayAdapter<ChatData> {

    private ArrayList<ChatData> items;

    public ChatAdapter(Context context, int textViewResourceId, ArrayList<ChatData> items) {
            super(context, textViewResourceId, items);
            this.items = items;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.item_list_chat, null);
            }
            ChatData p = items.get(position);
            if (p != null) {
                    TextView num = (TextView) v.findViewById(R.id.tv_contents);
                    
                    num.setText(p.contents);
            }
            return v;
    }
    
    public void insertItem ( ChatData inData ) {
    	items.add(inData);
    	
    	this.notifyDataSetChanged();
    }
    
    public void deleteItem ( ChatData inData ) {
    	items.remove(inData);
    	this.notifyDataSetChanged();
    }
 
    
}