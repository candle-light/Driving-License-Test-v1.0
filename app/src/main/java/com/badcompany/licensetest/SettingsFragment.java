package com.badcompany.licensetest;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Donatas on 07/09/2018.
 */

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }

}
