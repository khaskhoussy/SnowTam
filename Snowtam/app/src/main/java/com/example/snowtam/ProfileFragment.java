package com.example.snowtam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    TextView profileFirstName;
    TextView profileLastName;
    TextView profileEmail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profileFirstName = view.findViewById(R.id.firstNameView);
        profileLastName = view.findViewById(R.id.lastNameView);
        profileEmail = view.findViewById(R.id.emailView);

        profileFirstName.setText(LoginFragment.connectedUser.getFirstName());
        profileLastName.setText(LoginFragment.connectedUser.getLastName());
        profileEmail.setText(LoginFragment.connectedUser.getEmail());

        return view;
    }
}
