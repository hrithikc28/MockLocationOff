package com.example.hritikchauhan.mocklocationoffcompulsory;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    LocationAssistant assistant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean b =  isMockSettingsON(this);
        if(b == true){
            Settings.Secure.ALLOW_MOCK_LOCATION.set("0");
        }
        //assistant = new LocationAssistant(this, this, LocationAssistant.Accuracy.HIGH, 5000, false);
    }

    public static boolean isMockSettingsON(Context context) {
        // returns true if mock location enabled, false if not enabled.
        if (Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ALLOW_MOCK_LOCATION).equals("0"))
            return false;
        else
            return true;
    }
}
