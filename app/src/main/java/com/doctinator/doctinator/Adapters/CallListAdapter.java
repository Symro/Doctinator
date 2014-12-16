package com.doctinator.doctinator.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.doctinator.doctinator.R;
import com.doctinator.doctinator.models.CallList;

import java.util.ArrayList;

public class CallListAdapter extends ArrayAdapter<CallList> {

    public CallListAdapter(Context context, ArrayList<CallList> calls) {
        super(context,0, calls);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        // Get data from item position
        CallList call = getItem(position);

        // Inflate view if not being used
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.call_list_row, parent, false);
        }

        // Check for data population
        TextView name = (TextView) convertView.findViewById(R.id.callName);
        TextView description = (TextView) convertView.findViewById(R.id.callDescription);

        // Populate data
        name.setText(call.name);
        description.setText(call.description);

        return convertView;
    }

}
