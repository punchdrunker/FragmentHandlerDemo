package com.example.nein37.fragmenthandlerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("LIFECYLE", "onCreate");
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
              getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new FromFragment())
                    .commit();
        }


        Toast.makeText(this, System.getProperty("java.vm.specification.name"),
                Toast.LENGTH_SHORT).show();

        Toast.makeText(this, System.getProperty("java.vm.name"),
                Toast.LENGTH_SHORT).show();

        Toast.makeText(this, System.getProperty("java.vm.version"),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("LIFECYLE", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("LIFECYLE", "onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("LIFECYCLE", "onSaveInstanceState");

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    
}
