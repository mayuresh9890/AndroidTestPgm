package com.example.admin.gridexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 24/07/2017.
 */

public class CustomImageAdapter extends BaseAdapter {
    public String[] mThumbIds;
    private LayoutInflater mLayoutInflater;
    String[] values;
    String[] C_split;
    String Qurey_List[];
    private Context context;
    private String[] Qurey;


    public CustomImageAdapter(Context context, String[] Qurey){
        this.context = context;
        this.Qurey = Qurey;
        mLayoutInflater= LayoutInflater.from(context);

        mThumbIds = new String[Qurey.length];
        values=new String[Qurey.length];
        Qurey_List=Qurey;
        int i=0;

        for(String s: Qurey){
            mThumbIds[i++] = s;
        }
    }

    @Override
    public int getCount() {

        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.costomlay, parent,false);
            TextView button = (TextView) convertView.findViewById(R.id.text);
            button.setText(mThumbIds[position]);
        }
        return convertView;
    }

}
