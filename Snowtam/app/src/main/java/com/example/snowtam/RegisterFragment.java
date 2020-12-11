package com.example.snowtam;

import android.content.Context;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterFragment extends Fragment {
    Button register;
    EditText lastName;
    EditText firstName;
    EditText email;
    EditText password;
    EditText repeatPassword;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registre, container, false);
        register = view.findViewById(R.id.registerButton);
        lastName = view.findViewById(R.id.lastNameText);
        firstName = view.findViewById(R.id.firstNameText);
        email = view.findViewById(R.id.emailText);
        password = view.findViewById(R.id.passwordText);
        repeatPassword = view.findViewById(R.id.passwordRepat);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valEmail(email.getText().toString())) {
                    if (verifierMDP(password.getText().toString(), repeatPassword.getText().toString())) {
                        registerUser();
                        LoginFragment fragment = new LoginFragment();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.container, fragment);
                        transaction.commit();
                    }
                } else
                    Toast.makeText(getActivity().getBaseContext(), "email Format is invalid!!", Toast.LENGTH_LONG).show();

            }

        });


        return view;
    }

    String registerText(EditText firstName, EditText lastName, EditText email, EditText password) {
        return firstName.getText().toString() + "," + lastName.getText().toString() + "," + email.getText().toString() + "," + password.getText().toString();

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

    String putId(ArrayList<UsersDataBase> allUsers) {
        if (allUsers != null) {
            String lastId = getAllUsers().get(getAllUsers().size() - 1).getId();
            lastId = lastId.replace("\n", "");
            int newId = Integer.parseInt(lastId) + 1;
            return Integer.toString(newId) + ",";
        } else
            return "1,";
    }

    void registerUser() {
        try {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(getActivity().openFileOutput("testAndroid.txt", Context.MODE_APPEND));
            outputStreamWriter.write(putId(getAllUsers()) + registerText(firstName, lastName, email, password) + ";\n");
            outputStreamWriter.close();
            File fileDir = new File(getActivity().getFilesDir(), "myfile");
            Toast.makeText(getActivity().getBaseContext(), "Registration is done", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    void deleteAllUsers() {
        PrintWriter writer = null;
        try {
            File fileDir = new File(getActivity().getFilesDir(), "testAndroid.txt");
            writer = new PrintWriter(fileDir);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    boolean verifierMDP(String mdp1, String mdp2) {
        if (mdp1.equals(mdp2))
            return true;
        Toast.makeText(getActivity().getBaseContext(), "verifier votre mot de passe !!", Toast.LENGTH_LONG).show();
        return false;
    }

    boolean valEmail(String input) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(input);
        return matcher.find();
    }
}
