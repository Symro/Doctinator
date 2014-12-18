package com.doctinator.doctinator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class FirstHelpActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_help);

        // Get the list view concerned
        final ListView listView = (ListView) findViewById(R.id.gestureList);

        // Array to show in listview
        String[] gestureMenu = new String[]{
            "Inconscience",
            "Arrêt cardiaque",
            "Étouffement",
            "Fracture",
            "Plaie",
            "Brûlure"
        };

        // Define adapter
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, gestureMenu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.first_help_row, R.id.txtGesture ,gestureMenu);
        // Reference to listview
        ListView lv = (ListView) this.findViewById(R.id.gestureList);
        lv.setAdapter(adapter);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // list view click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Log row informations
                // Toast.makeText(getApplicationContext(),
                    //"Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                    //.show();

                // Prepare a new Intent
                Intent tutorialNextScreen = new Intent(getApplicationContext(), TutoActivity.class);

                // Passing id to next Intent
                Bundle tutorialId = new Bundle();
                tutorialId.putInt("key", itemPosition); //Your id
                tutorialNextScreen.putExtras(tutorialId); //Put your id to your next Intent

                // Start the new activity
                startActivity(tutorialNextScreen);

            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_help, menu);
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
