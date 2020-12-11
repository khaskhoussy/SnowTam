package com.example.snowtam;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SearchFragment extends Fragment {

    public String coded;
    public static TextView textView1;
    public static TextView textView2;
    public static TextView textView3;
    public static TextView textView4;
    public static Button bres1;
    public static Button bres2;
    public static Button bres3;
    public static Button bres4;

    public TextView searchBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Search Snowtam");
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        textView1 = view.findViewById(R.id.airoport1);
        textView2 = view.findViewById(R.id.airoport2);
        textView3 = view.findViewById(R.id.airoport3);
        textView4 = view.findViewById(R.id.airoport4);
        searchBar = view.findViewById(R.id.editText);
        bres1 = view.findViewById(R.id.bres1);
        bres2 = view.findViewById(R.id.bres2);
        bres3 = view.findViewById(R.id.bres3);
        bres4 = view.findViewById(R.id.bres4);
        Button button = (Button) view.findViewById(R.id.button2);
        SearchFragment.bres1.setVisibility(View.INVISIBLE);
        SearchFragment.bres2.setVisibility(View.INVISIBLE);
        SearchFragment.bres3.setVisibility(View.INVISIBLE);
        SearchFragment.bres4.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FetchDataAeroport process = new FetchDataAeroport();
                process.setCodeSearch(searchBar.getText().toString());
                process.execute();


            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FetchDataAeroport fetchDataAeroport = new FetchDataAeroport();
                SnowTam fragment = new SnowTam();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                if (!textView1.getText().toString().equals("Result1")) {

                    if (searchBar.getText().toString().contains(";")) {
                        fragment.setSearchFor(searchBar.getText().toString().split(";")[0]);
                        fragment.setLatitude(FetchDataAeroport.latitude1);
                        fragment.setLongitude(FetchDataAeroport.longitude1);
                        fragment.setName(FetchDataAeroport.name1);

                    } else
                        fragment.setSearchFor(searchBar.getText().toString());

                    fragment.setLatitude(FetchDataAeroport.latitude1);
                    fragment.setLongitude(FetchDataAeroport.longitude1);
                    fragment.setName(FetchDataAeroport.name1);
                    System.out.println(searchBar.getText().toString().split(";")[0]);
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.addToBackStack(null).commit();
                }

            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SnowTam fragment = new SnowTam();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                if (!textView2.getText().toString().equals("Result2")) {
                    fragment.setSearchFor(searchBar.getText().toString().split(";")[1]);
                    fragment.setLatitude(FetchDataAeroport.latitude2);
                    fragment.setLongitude(FetchDataAeroport.longitude2);
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.addToBackStack(null).commit();
                }
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SnowTam fragment = new SnowTam();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                if (!textView3.getText().toString().equals("Result3")) {
                    fragment.setSearchFor(searchBar.getText().toString().split(";")[2]);
                    fragment.setLatitude(FetchDataAeroport.latitude3);
                    fragment.setLongitude(FetchDataAeroport.longitude3);
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.addToBackStack(null).commit();
                }

            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SnowTam fragment = new SnowTam();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                if (!textView4.getText().toString().equals("Result4")) {
                    fragment.setSearchFor(searchBar.getText().toString().split(";")[3]);
                    fragment.setLatitude(FetchDataAeroport.latitude4);
                    fragment.setLongitude(FetchDataAeroport.longitude4);
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.addToBackStack(null).commit();
                }

            }
        });

        return view;
    }


}