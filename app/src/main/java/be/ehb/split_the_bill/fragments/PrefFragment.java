package be.ehb.split_the_bill.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.preference.PreferenceFragmentCompat;

import be.ehb.split_the_bill.R;

public class PrefFragment extends PreferenceFragmentCompat {
    public static PrefFragment newInstance() {
        return new PrefFragment();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Inflate the layout for this fragment
        setPreferencesFromResource(R.xml.preferences, rootKey);

    }
}

