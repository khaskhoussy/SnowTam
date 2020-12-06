package com.example.snowtam;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class SnowTam extends Fragment {

    private String searchFor ;
    private double latitude ;
    private double longitude;
    Button location ;
    public static TextView textView ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view ;
          view = inflater.inflate(R.layout.fragment_snowtam, container, false);
        FetchDataSnowTam process = new FetchDataSnowTam();
        process.setCodeSnowTam(this.searchFor);
        process.execute();

        location = view.findViewById(R.id.location);
        textView = view.findViewById(R.id.textView);




        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapFragment fragment = new mapFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                    fragment.setLatitude(latitude);
                    fragment.setLongitude(longitude);
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.commit();

            }
        });

        return view;
    }

    public void setSearchFor(String searchFor) {
        this.searchFor = searchFor;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
