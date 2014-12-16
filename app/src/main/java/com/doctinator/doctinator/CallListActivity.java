package com.doctinator.doctinator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

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
        ListView listView = (ListView) findViewById(R.id.callListView);
        listView.setAdapter(adapter);

        // populating array
        CallList newCall = new CallList("Pompiers", "...", 18);
        CallList newCall1 = new CallList("SAMU", "...", 15);
        CallList newCall2 = new CallList("Police", "...", 17);
        adapter.add(newCall);
        adapter.add(newCall1);
        adapter.add(newCall2);

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
