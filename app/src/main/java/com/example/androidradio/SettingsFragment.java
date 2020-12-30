package com.example.androidradio;


import android.os.Bundle;
import android.transition.TransitionInflater;
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
        preference.setOnPreferenceChangeListener((preference, newValue) -> {
            Log.e("CHANGE", "TO: ".concat(newValue.toString()));
            MainActivity.setDefaultChannel(Integer.parseInt(newValue.toString()));
            return true;
        });

        disableSongs = findPreference("enable_songs");
        disableSongs.setOnPreferenceChangeListener((preference, newValue) -> {
            Log.e("CHANGE", "TO: ".concat(newValue.toString()));
            MainActivity.setShowSongs((Boolean) newValue);
            return true;
        });

        TransitionInflater inflater = TransitionInflater.from(requireContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slide_in));
        setExitTransition(inflater.inflateTransition(R.transition.slide_in));
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);
    }
}
