package com.example.snowtam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DecodedFragment extends Fragment {
    private String searchFor;
    public static TextView decodedTV;

    FetchDataSnowTamDecoded fetchedDecoded = new FetchDataSnowTamDecoded();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_decoded, container, false);


       /*FetchDataSnowTam process = new FetchDataSnowTam();
        process.setCodeSnowTam(this.searchFor);
        process.execute();*/
        // String airportName = getArguments().getString("airportName");
        //String fetchedSnowtam = getArguments().getString("fetchedSnowtam");
        //  String fetchedSnowtam = process.textCode;

        decodedTV = view.findViewById(R.id.decoded);
        // decodedSnowtam=fetchedDecoded.SnowtamDecoded(""+fetchedSnowtam,"Airport: ");
        // decodedTV.setText(decodedSnowtam);
        // decodedTV.setText(decodedSnowtam);

        // decodedTV.setText(decodedSnowtam);
        return view;
    }

 /*   public void setSearchFor(String searchFor) {
        this.searchFor = searchFor;
    }*/
}