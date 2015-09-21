package com.secmem.layer;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.secmem.spentest2.R;

public class LayerAdapter extends ArrayAdapter<LayerData> {

    private ArrayList<LayerData> items;

    public LayerAdapter(Context context, int textViewResourceId, ArrayList<LayerData> items) {
            super(context, textViewResourceId, items);
            this.items = items;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.item_list_layer, null);
            }
            LayerData p = items.get(position);
            if (p != null) {
                    TextView num = (TextView) v.findViewById(R.id.tv_layer_name);
     //               num.setText(p.name);
            }
            return v;
    }
    
    public void insertItem ( LayerData inData ) {
    	items.add(inData);
    	
    	this.notifyDataSetChanged();
    }
    
    public void deleteItem ( LayerData inData ) {
    	items.remove(inData);
    	this.notifyDataSetChanged();
    }
 
    
}