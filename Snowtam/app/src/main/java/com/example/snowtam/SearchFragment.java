package com.example.snowtam;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class SearchFragment extends Fragment {

    public String coded;
    public static TextView textView;
    public TextView searchBar ;
    @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_search, container, false);
            textView= view.findViewById(R.id.textView3);
            searchBar = view.findViewById(R.id.editText);
            Button button = (Button) view.findViewById(R.id.button2);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    FetchData process = new FetchData();
                    process.setCodeSnowTam(searchBar.getText().toString());
                    process.execute();


                }
            });

            return view;
        }


    }