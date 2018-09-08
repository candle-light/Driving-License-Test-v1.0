package com.badcompany.licensetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Donatas on 07/09/2018.
 */

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();

    }
}
