package com.example.snowtam;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class FetchDataAeroport extends AsyncTask<Void,Void,Void> {

    private String codeSearch ;
    String result1 =null ;
    String result2 =null;
    String result3 =null;

    public  static double latitude1 ;
    public  static double longitude1 ;
    public  static double latitude2 ;
    public  static double longitude2 ;
    public  static double latitude3;
    public  static double longitude3 ;


    private  String retrieveData (String search){
        String data ="";
        try {
            URL url = new URL("https://applications.icao.int/dataservices/api/indicators-list?api_key=b0736d30-372e-11eb-854c-318dff0799ba&state=&airports="+search+"&format=json");
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


    private String searchAeroport(String data)
    {
        String result="" ;
        String objects[] = null;

        objects = data.split("\\{");
        String object[] =objects[1].split("\",");
        for (int i = 0 ;i <=3 ; i++)
            result = result +objects[1].split("\",")[i]+"\n";

        String latitudeS =  objects[1].split("\",")[4].split(":")[1];
        String lon = objects[1].split("\",")[5].split(":")[1] ;




        return result.replaceAll("\"","");
    }

    private String Latitude(String data)
    {
        String result="" ;
        String objects[] = null;
        objects = data.split("\\{");
        String object[] =objects[1].split("\",");
        String latitudeS =  objects[1].split("\",")[4].split(":")[1];
//        String lon = objects[1].split("\",")[5].split(":")[1] ;
        return objects[1].split("\",")[4].split(":")[1].split(",")[0];
    }
    private String longitude(String data)
    {
        String result="" ;
        String objects[] = null;
        objects = data.split("\\{");
        String object[] =objects[1].split("\",");
        return objects[1].split("\",")[4].split(",")[1].split(":")[1];
    }


    @Override
    protected Void doInBackground(Void... voids) {


        this.codeSearch.split(";");
        switch ( this.codeSearch.split(";").length) {
            case 1:
                result1 = searchAeroport(retrieveData(this.codeSearch.split(";")[0]));
                latitude1 = Double.parseDouble(Latitude(retrieveData(this.codeSearch.split(";")[0])));
                longitude1 = Double.parseDouble(longitude(retrieveData(this.codeSearch.split(";")[0])));
                break;
            case 2 :
                result1 = searchAeroport(retrieveData(this.codeSearch.split(";")[0]));
                latitude1 = Double.parseDouble(Latitude(retrieveData(this.codeSearch.split(";")[0])));
                longitude1 = Double.parseDouble(longitude(retrieveData(this.codeSearch.split(";")[0])));
                result2 = searchAeroport(retrieveData(this.codeSearch.split(";")[1]));
                latitude2 = Double.parseDouble(Latitude(retrieveData(this.codeSearch.split(";")[1])));
                longitude2 = Double.parseDouble(longitude(retrieveData(this.codeSearch.split(";")[1])));
                break;
            case 3 :
                result1 = searchAeroport(retrieveData(this.codeSearch.split(";")[0]));
                latitude1 = Double.parseDouble(Latitude(retrieveData(this.codeSearch.split(";")[0])));
                longitude1 = Double.parseDouble(longitude(retrieveData(this.codeSearch.split(";")[0])));
                result2 = searchAeroport(retrieveData(this.codeSearch.split(";")[1]));
                latitude2 = Double.parseDouble(Latitude(retrieveData(this.codeSearch.split(";")[1])));
                longitude2 = Double.parseDouble(longitude(retrieveData(this.codeSearch.split(";")[1])));
                result3 = searchAeroport(retrieveData(this.codeSearch.split(";")[2]));
                latitude3 = Double.parseDouble(Latitude(retrieveData(this.codeSearch.split(";")[2])));
                longitude3 = Double.parseDouble(longitude(retrieveData(this.codeSearch.split(";")[2])));
                break;
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(result1 != null) {
            SearchFragment.textView1.setText(result1);

            }
        else
            SearchFragment.textView1.setText("no Search here ");
        if(result2 != null) {
//            Log.d("Success", result1);
//            Log.d("Success", result1);
            SearchFragment.textView2.setText(result2);
        }
        else
            SearchFragment.textView2.setText("no result here ");
        if(result3 != null) {
//            Log.d("Success", result1);
            SearchFragment.textView3.setText(result3);
        }
        else
            SearchFragment.textView3.setText("no Result here ");

    }

    public void setCodeSearch(String codeSearch) {
        this.codeSearch = codeSearch;
    }

    public String getCodeSearch() {
        return codeSearch;
    }

}
