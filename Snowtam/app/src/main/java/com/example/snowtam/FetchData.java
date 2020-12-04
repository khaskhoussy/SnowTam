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

public class FetchData extends AsyncTask<Void,Void,Void> {
    String data;
    String dataParsed = "";
    String singleParsed="empty" ;
    String[] result1;
    String[] result2;
    String[] result3 ;
    ArrayList<String> finalResult;
    public JSONArray JA;
    private String codeSnowTam;
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://applications.icao.int/dataservices/api/notams-realtime-list?api_key=0ca39160-3564-11eb-82b5-b7393cc531f7&format=json&criticality=1&locations="+this.codeSnowTam);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while( line != null){
                line = bufferedReader.readLine();
                data = data +line ;
            }

             result1 = data.split("\\{");
             result2 = result1[result1.length-1].split("\",");
             result3 = result2[12].split("n");
             finalResult = new ArrayList<String>();
            for (int i = 0;i< result3.length-1 ; i++)
            {
                finalResult.add(result3[i]);
            }








        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        String textCode = "";
            for(int i= 2 ;i <finalResult.size() ;i++ )
                textCode = textCode + finalResult.get(i).substring(0,finalResult.get(i).length()-1)+"\n";
            SearchFragment.textView.setText(textCode);
                 textCode="" ;
//            finalResult.forEach(e -> Success","this is your Text !!! \n"+e));
                    Log.d("Success",result2[12]);

    }

    public void setCodeSnowTam(String codeSnowTam) {
        this.codeSnowTam = codeSnowTam;
    }
}
