package com.example.snowtam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class SplashscreenActivity extends AppCompatActivity {

    //variables:
    Animation topAnim, bottomAnim;
    ImageView img;
    TextView logo;
    Button login;
    Button register;
    ConstraintLayout view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        register = findViewById(R.id.register);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        img = findViewById(R.id.imageView2);
        logo = findViewById(R.id.textView);

        img.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
//                Intent i = new Intent(getApplicationContext(),LoginFragment.class);
//                startActivity(i);
                img.setVisibility(view.INVISIBLE);
                login.setVisibility(view.INVISIBLE);
                logo.setVisibility(view.INVISIBLE);
                register.setVisibility(view.INVISIBLE);

                FragmentManager fm = getSupportFragmentManager();
                LoginFragment fl = new LoginFragment();
                fm.beginTransaction().replace(R.id.container, fl).commit();
                //user Creation
//                try {
//
//                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("testAndroid.txt", Context.MODE_APPEND));
//                    outputStreamWriter.write("\ndata");
//                    outputStreamWriter.close();
//                    File fileDir = new File(getFilesDir(),"myfile");
//                    Toast.makeText(getBaseContext(), "fichier écrit"+fileDir, Toast.LENGTH_LONG).show();
//                }
//                catch (IOException e) {
//                    Log.e("Exception", "File write failed: " + e.toString());
//                }

                //get Alluser
//                try {
//                    FileInputStream fIn = openFileInput("testAndroid.txt");
//                    int c;
//                    String temp ="";
//                    while ((c = fIn.read())!=-1){
//                        temp = temp + Character.toString((char)c);
//                    }
//                    Log.e("result", temp);
//                }
//                catch (Exception e ){
//                    e.printStackTrace();
//                }
//

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img.setVisibility(view.INVISIBLE);
                login.setVisibility(view.INVISIBLE);
                logo.setVisibility(view.INVISIBLE);
                register.setVisibility(view.INVISIBLE);

                FragmentManager fm = getSupportFragmentManager();
                RegisterFragment fl = new RegisterFragment();
                fm.beginTransaction().replace(R.id.container, fl).commit();
            }
        });
    }
}
