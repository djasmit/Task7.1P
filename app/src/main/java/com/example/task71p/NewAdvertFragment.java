package com.example.task71p;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.task71p.data.DatabaseHelper;
import com.example.task71p.model.Advert;

public class NewAdvertFragment extends Fragment {
    DatabaseHelper db;

    public NewAdvertFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_advert, container, false);
    }

    //actions to take after the view has been inflated
    @Override public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        EditText nameEditText = view.findViewById(R.id.nameEditText);
        EditText phoneEditText = view.findViewById(R.id.phoneEditText);
        EditText descEditText = view.findViewById(R.id.descEditText);
        EditText dateEditText = view.findViewById(R.id.editTextDate);
        EditText locEditText = view.findViewById(R.id.locateEditText);
        Button saveButton = view.findViewById(R.id.saveButton);

        RadioButton lostButton = view.findViewById(R.id.lostRadioButton);
        RadioButton foundButton = view.findViewById(R.id.foundRadioButton);

        db = new DatabaseHelper(getContext());

        //save button returns to previous fragment
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameString = nameEditText.getText().toString();
                String phoneString = phoneEditText.getText().toString();
                String descString = descEditText.getText().toString();
                String dateString = dateEditText.getText().toString();
                String locString = locEditText.getText().toString();

                //check which category the advert is in, but return if there's no category
                String type;
                if (lostButton.isChecked()) { type = "Lost"; }
                else if (foundButton.isChecked()) { type = "Found"; }
                else {
                    Toast.makeText(getContext(), "Please select advert category.", Toast.LENGTH_SHORT).show();
                    return;
                }

                //check for empty entries
                if (nameString.trim().equals("")) {
                    Toast.makeText(getContext(), "Please enter a name.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (descString.trim().equals("")) {
                    Toast.makeText(getContext(), "Please enter a description.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (dateString.trim().equals("")) {
                    Toast.makeText(getContext(), "Please enter a date.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (locString.trim().equals("")) {
                    Toast.makeText(getContext(), "Please enter a location.", Toast.LENGTH_SHORT).show();
                    return;
                }

                //all data valid, so create the advert
                long result = db.insertAdvert(new Advert(type, nameString, phoneString, descString, dateString, locString));
                if (result > 0) {
                    Toast.makeText(getContext(), "Registered advert successfully!", Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager().popBackStack();
                }
                else {
                    Toast.makeText(getContext(), "Register error!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}