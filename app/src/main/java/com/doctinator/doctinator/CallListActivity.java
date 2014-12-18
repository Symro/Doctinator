package com.doctinator.doctinator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.doctinator.doctinator.Adapters.CallListAdapter;
import com.doctinator.doctinator.models.CallList;

import java.util.ArrayList;
import java.util.List;


public class CallListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_list);

        // Data source
        ArrayList<CallList> arrayOfCalls = new ArrayList<CallList>();

        // Convert the array to views
        CallListAdapter adapter = new CallListAdapter(this, arrayOfCalls);

        // Attach the adapter to the listView
        final ListView listView = (ListView) findViewById(R.id.callListView);
        listView.setAdapter(adapter);

        // populating array
        CallList newCall = new CallList("18 - Pompiers", "...", 18);
        CallList newCall1 = new CallList("15 - SAMU", "...", 15);
        CallList newCall2 = new CallList("Police", "...", 17);
        CallList newCall3 = new CallList("112 - Numéro d'urgence européen", "...", 112);
        CallList newCall4 = new CallList("114 - Sourds et malentendants", "...", 114);
        adapter.add(newCall);
        adapter.add(newCall1);
        adapter.add(newCall2);
        adapter.add(newCall3);
        adapter.add(newCall4);

        // list view click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                if(itemPosition == 1){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:666"));
                    startActivity(callIntent);
                }

                switch (itemPosition){
                    case 0:
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:666"));
                        startActivity(callIntent);
                        break;
                    case 1:
                        callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:666"));
                        startActivity(callIntent);
                        break;
                    case 2:
                        callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:666"));
                        startActivity(callIntent);
                        break;

                }

            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_call_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
