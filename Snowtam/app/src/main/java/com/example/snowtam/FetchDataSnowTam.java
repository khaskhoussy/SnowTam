package com.example.snowtam;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonObject;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class FetchDataSnowTam extends AsyncTask<Void,Void,Void> {


    ArrayList<String> myResult = new ArrayList<>();
    private String codeSnowTam;






    //look if wi have snowTam or not and render it if there is one
    private String checkSnowTam(String object){

        String all=null ;

        for (int i =0;i<object.split("\",").length-1;i++)
        {
            if(object.split("\",")[i].contains("all"))
            all = object.split("\",")[i];
        }
       if(all.contains("SNOWTAM"))
           return all;

       return all = null;
    }


    //retrive all data that exist in the URL
    private  String retrieveData (String search){
        String data ="";
        try {
            URL url = new URL("https://applications.icao.int/dataservices/api/notams-realtime-list?api_key=b0736d30-372e-11eb-854c-318dff0799ba&format=json&criticality=1&locations="+search);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while( line != null){
                line = bufferedReader.readLine();
                data = data +line ;
            }
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return data ;
    }



    // if SnowTam exists return it in List else return null
    @RequiresApi(api = Build.VERSION_CODES.N)
    private ArrayList<String> searchSnowTam(String data )
    {
        ArrayList<String> result=new ArrayList<String>() ;
        String objects[] = null;

         objects = data.split("\\{");
         for(int i= 1 ;i<objects.length-1 ;i++)
         {
             if(checkSnowTam(objects[i]) != null) {
                 for (int j = 0; j < checkSnowTam(objects[i]).split("n").length - 1; j++)
                        result.add(checkSnowTam(objects[i]).split("n")[j]);
                 return result;
             }
         }
         return null;
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Void doInBackground(Void... voids) {

                myResult = searchSnowTam(retrieveData(this.codeSnowTam));

        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        String textCode = "";
        if(myResult != null)
        {
            for (int i = 2; i < myResult.size(); i++)
                textCode = textCode + myResult.get(i).substring(0, myResult.get(i).length() - 1) + "\n";//delete the \ that exist in the End
            SnowTam.textView.setText(textCode);
        }
            else
            SnowTam.textView.setText("No SnowTam");
                  //  Log.d("Success",myResult.toString());

    }

    public void setCodeSnowTam(String codeSnowTam) {
        this.codeSnowTam = codeSnowTam;
    }

}


