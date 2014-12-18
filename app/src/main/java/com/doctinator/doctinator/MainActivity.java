package com.doctinator.doctinator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set actionbar title
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle(getResources().getString(R.string.titleMain));

        // Get buttons to add listener
        Button yesButtonCall = (Button) findViewById(R.id.yesCallButton);
        Button noButtonCall = (Button) findViewById(R.id.noCallButton);

        // yes button click redirection
        yesButtonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Starting a new Intent
                Intent yesNextScreen = new Intent(getApplicationContext(), CallListActivity.class);
                startActivity(yesNextScreen);
            }
        });

        // No button click redirection
        noButtonCall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call alert dialog method
                showDialog();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    protected void showDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Que voulez-vous faire ?");

        alert.setPositiveButton("Gestes de premiers secours", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent NextScreen = new Intent(getApplicationContext(), FirstHelpActivity.class);
                startActivity(NextScreen);
            }
        });

        alert.setNegativeButton("Trouver un établissement", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent NextScreen = new Intent(getApplicationContext(), FindPlace.class);
                startActivity(NextScreen);
            }
        });

        alert.show();
    }

}
