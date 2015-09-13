package com.example.sensorssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    CompassManager compassManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compassManager = new CompassManager(getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        compassManager.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        compassManager.stop();
    }

    @Override
    protected void onDestroy() {
        compassManager = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
