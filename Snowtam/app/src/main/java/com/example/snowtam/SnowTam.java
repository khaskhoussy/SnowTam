package com.example.snowtam;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SnowTam extends Fragment {

    private String searchFor;
    private double latitude;
    private double longitude;
    private String name;
    Button location;
    public static TextView textView;
    public static TextView decodedTV;
    public static TextView airport_name_tv;

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2;
    public static String decodedSnowtam = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_snowtam, container, false);
        //   decodedSnowtam=getArguments().getString("decoded");

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Airport Snowtam");

        FetchDataSnowTam process = new FetchDataSnowTam();
        process.setCodeSnowTam(this.searchFor);
        process.execute();
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        location = view.findViewById(R.id.location);
        textView = view.findViewById(R.id.textView);


        airport_name_tv = view.findViewById(R.id.airport_name_tv);

        airport_name_tv.setText("Airport's Name: " + name);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapFragment fragment = new mapFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                fragment.setLatitude(latitude);
                fragment.setLongitude(longitude);
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null).commit();

            }
        });

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
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

    public void setName(String name) {
        this.name = name;
    }


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;
            Bundle bundle = new Bundle();
            bundle.putString("e", "test");
            switch (position) {
                case 0:
                    fragment = new OriginalFragment();
                    //  fragment.setArguments(bundle);
                    break;

                case 1:
                    fragment = new DecodedFragment();
                    fragment.setArguments(bundle);
            }
            return fragment;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    String tab1 = "Original ";
                    return tab1;
                case 1:
                    String tab2 = "Decoded";
                    return tab2;
            }
            return null;
        }
    }
}
