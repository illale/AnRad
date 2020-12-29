package com.example.androidradio;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat {
    Preference preference;
    Preference disableSongs;

    public SettingsFragment() {

    }

    @org.jetbrains.annotations.NotNull
    public static SettingsFragment newInstance() {
        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preference = findPreference("default_channel");
        preference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Log.e("CHANGE", "TO: ".concat(newValue.toString()));
                MainActivity.setDefaultChannel(MainActivity.getChannelId(newValue.toString()));
                return true;
            }
        });

        disableSongs = findPreference("enable_songs");
        disableSongs.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Log.e("CHANGE", "TO: ".concat(newValue.toString()));
                MainActivity.setShowSongs((Boolean) newValue);
                return true;
            }
        });


    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);
    }
}
