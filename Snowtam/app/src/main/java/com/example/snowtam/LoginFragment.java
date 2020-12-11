package com.example.snowtam;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class LoginFragment extends Fragment {
    Button loginButton;
    EditText email;
    EditText passowrd;
    public static UsersDataBase connectedUser = null;

    public LoginFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        loginButton = view.findViewById(R.id.loginButton);
        email = view.findViewById(R.id.email);
        passowrd = view.findViewById(R.id.pswd);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (doesUserExist(email.getText().toString(), passowrd.getText().toString()).equals("n"))
                    Toast.makeText(getActivity().getBaseContext(), "User does not Exist ", Toast.LENGTH_LONG).show();
                else if (doesUserExist(email.getText().toString(), passowrd.getText().toString()).equals("p"))
                    Toast.makeText(getActivity().getBaseContext(), "Check your password ", Toast.LENGTH_LONG).show();
                else {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), MainActivity.class);
                    getActivity().startActivity(intent);
                }

            }
        });

        return view;
    }

    ArrayList<UsersDataBase> getAllUsers() {
        ArrayList<UsersDataBase> allUsers = new ArrayList<>();
        try {
            FileInputStream fIn = getActivity().openFileInput("testAndroid.txt");
            int c;
            String temp = "";
            while ((c = fIn.read()) != -1) {
                temp = temp + Character.toString((char) c);
            }
            if (temp == "")
                return null;

            String allChar[] = temp.split(";");
            for (int i = 0; i < allChar.length - 1; i++) {
                allUsers.add(new UsersDataBase(allChar[i].split(",")[0], allChar[i].split(",")[1], allChar[i].split(",")[2],
                        allChar[i].split(",")[3], allChar[i].split(",")[4]));
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
        return allUsers;
    }

    String doesUserExist(String entredmail, String entredPassword) {
        String result = "n";

        for (int i = 0; i <= getAllUsers().size() - 1; i++) {
            if (getAllUsers().get(i).getEmail().equals(entredmail))
                connectedUser = getAllUsers().get(i);
        }
        if (connectedUser != null) {
            if (connectedUser.getPassword().equals(entredPassword))
                result = "c";
            else
                result = "p";
        }


        return result;


    }
}
