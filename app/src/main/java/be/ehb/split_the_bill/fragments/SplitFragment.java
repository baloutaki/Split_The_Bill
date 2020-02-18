package be.ehb.split_the_bill.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import be.ehb.split_the_bill.R;

import static be.ehb.split_the_bill.R.id.tilt_tip;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplitFragment extends Fragment {

    public static SplitFragment newInstance() {
        return new SplitFragment();
    }

    private EditText etAmount, etTip, etParty;
    private TextView tvResult;
    private Button btnSplit;

    private View.OnClickListener splitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(! etAmount.getText().toString().isEmpty() && ! etTip.getText().toString().isEmpty() && ! etParty.getText().toString().isEmpty()) {
                double amount = Double.parseDouble((etAmount.getText().toString()));
                double tip = Double.parseDouble((etTip.getText().toString()));
                double party = Double.parseDouble((etParty.getText().toString()));
                double result = (amount + tip) / party;
                tvResult.setText(String.format(Locale.getDefault(), "%.2f per person", result));
            }else{
                tvResult.setText("One or more fields are empty");
                return;
            }
        }
    };


        public SplitFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View root = inflater.inflate(R.layout.fragment_split, container, false);
            etAmount = root.findViewById(R.id.tilt_amount);
            etTip = root.findViewById(R.id.tilt_tip);
            etParty = root.findViewById(R.id.tilt_party);
            tvResult = root.findViewById(R.id.lbl);
            btnSplit = root.findViewById(R.id.btn_split);
            btnSplit.setOnClickListener(splitListener);
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
            String tip = getResources().getString(R.string.pref_text_tip);
            String givenTip = prefs.getString(tip, "");
            etTip.setText(givenTip);

            return root;

        }

    }



