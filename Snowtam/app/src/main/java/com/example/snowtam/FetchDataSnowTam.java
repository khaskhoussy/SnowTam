package com.example.snowtam;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class FetchDataSnowTam extends AsyncTask<Void, Void, Void> {


    ArrayList<String> myResult = new ArrayList<>();
    private String codeSnowTam;

    public String textCode;

    FetchDataSnowTamDecoded fetchedDecoded = new FetchDataSnowTamDecoded();
    String decodedSnowtam = "";


    //look if wi have snowTam or not and render it if there is one
    private String checkSnowTam(String object) {

        String all = "";

        for (int i = 0; i < object.split("\",").length - 1; i++) {
            if (object.split("\",")[i].contains("all"))
                all = object.split("\",")[i];
        }
        if (all.contains("SNOWTAM"))
            return all;

        return all = null;
    }


    //retrive all data that exist in the URL
    private String retrieveData(String search) {
        String data = "[\n" +
                "  {\n" +
                "    \"id\": \"V0449/20\",\n" +
                "    \"entity\": \"PI\",\n" +
                "    \"status\": \"LT\",\n" +
                "    \"Qcode\": \"PILT\",\n" +
                "    \"Area\": \"ATM\",\n" +
                "    \"SubArea\": \"Air traffic procedures\",\n" +
                "    \"Condition\": \"Limitations\",\n" +
                "    \"Subject\": \"Instrument approach procedure\",\n" +
                "    \"Modifier\": \"Limited to\",\n" +
                "    \"message\": \"[US DOD PROCEDURAL NOTAM] INSTRUMENT APPROACH PROCEDURE LIMITED\\n TACAN RWY 07, TACAN-A, ILS M OR LOC M RWY 07 AND ILS M OR LOC M RWY\\n 25. AUTHORIZED FOR NORWEGIAN MILITARY AIRCRAFT ONLY.\\nCREATED: 23 Sep 2020 13:17:00 \\nSOURCE: KQZC\",\n" +
                "    \"startdate\": \"2020-09-23T13:17:00.000Z\",\n" +
                "    \"enddate\": \"2020-12-08T12:00:00.000Z\",\n" +
                "    \"all\": \"V0449/20 NOTAMN \\nQ) ENOR/QPILT/I/BO/A/000/999/6716N01421E005 A) ENBO B) 2009231317 C) 2012081200\\nE) [US DOD PROCEDURAL NOTAM] INSTRUMENT APPROACH PROCEDURE LIMITED\\n TACAN RWY 07, TACAN-A, ILS M OR LOC M RWY 07 AND ILS M OR LOC M RWY\\n 25. AUTHORIZED FOR NORWEGIAN MILITARY AIRCRAFT ONLY.\\nCREATED: 23 Sep 2020 13:17:00 \\nSOURCE: KQZC\",\n" +
                "    \"location\": \"ENBO\",\n" +
                "    \"isICAO\": true,\n" +
                "    \"Created\": \"2020-09-23T13:17:00.000Z\",\n" +
                "    \"key\": \"V0449/20-ENBO\",\n" +
                "    \"type\": \"airport\",\n" +
                "    \"StateCode\": \"NOR\",\n" +
                "    \"StateName\": \"Norway\",\n" +
                "    \"criticality\": -1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"A4325/20\",\n" +
                "    \"entity\": \"OB\",\n" +
                "    \"status\": \"CE\",\n" +
                "    \"Qcode\": \"OBCE\",\n" +
                "    \"Area\": \"Other Information\",\n" +
                "    \"SubArea\": \"Other Information\",\n" +
                "    \"Condition\": \"Changes\",\n" +
                "    \"Subject\": \"Obstacle\",\n" +
                "    \"Modifier\": \"Erected\",\n" +
                "    \"message\": \"OBST ERECTED 1135 METERS SOUTH EAST OF THR 25, 148FT AMSL\\nCREATED: 04 Dec 2020 13:24:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"startdate\": \"2020-12-04T13:24:00.000Z\",\n" +
                "    \"enddate\": \"2020-12-18T23:00:00.000Z\",\n" +
                "    \"all\": \"A4325/20 NOTAMN\\nQ) ENOR/QOBCE/IV/M  /A /000/999/6716N01422E005\\nA) ENBO B) 2012041324 C) 2012182300\\nE) OBST ERECTED 1135 METERS SOUTH EAST OF THR 25, 148FT AMSL\\nCREATED: 04 Dec 2020 13:24:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"location\": \"ENBO\",\n" +
                "    \"isICAO\": true,\n" +
                "    \"Created\": \"2020-12-04T13:24:00.000Z\",\n" +
                "    \"key\": \"A4325/20-ENBO\",\n" +
                "    \"type\": \"airport\",\n" +
                "    \"StateCode\": \"NOR\",\n" +
                "    \"StateName\": \"Norway\",\n" +
                "    \"criticality\": -1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"A3886/20\",\n" +
                "    \"entity\": \"FU\",\n" +
                "    \"status\": \"AH\",\n" +
                "    \"Qcode\": \"FUAH\",\n" +
                "    \"Area\": \"AGA\",\n" +
                "    \"SubArea\": \"Facilities and services\",\n" +
                "    \"Condition\": \"Availability\",\n" +
                "    \"Subject\": \"Fuel availability\",\n" +
                "    \"Modifier\": \"Hours of service\",\n" +
                "    \"message\": \"HRS OF FUEL: MON-FRI 0400-2030, SAT 0530-1330, SUN 0930-2030\\nCREATED: 26 Oct 2020 14:15:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"startdate\": \"2020-10-26T14:30:00.000Z\",\n" +
                "    \"enddate\": \"2021-03-27T23:00:00.000Z\",\n" +
                "    \"all\": \"A3886/20 NOTAMN\\nQ) ENOR/QFUAH/IV/NBO/A /000/999/6716N01422E005\\nA) ENBO B) 2010261430 C) 2103272300\\nE) HRS OF FUEL: MON-FRI 0400-2030, SAT 0530-1330, SUN 0930-2030\\nCREATED: 26 Oct 2020 14:15:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"location\": \"ENBO\",\n" +
                "    \"isICAO\": true,\n" +
                "    \"Created\": \"2020-10-26T14:15:00.000Z\",\n" +
                "    \"key\": \"A3886/20-ENBO\",\n" +
                "    \"type\": \"airport\",\n" +
                "    \"StateCode\": \"NOR\",\n" +
                "    \"StateName\": \"Norway\",\n" +
                "    \"criticality\": -1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"A3412/20\",\n" +
                "    \"entity\": \"PI\",\n" +
                "    \"status\": \"LT\",\n" +
                "    \"Qcode\": \"PILT\",\n" +
                "    \"Area\": \"ATM\",\n" +
                "    \"SubArea\": \"Air traffic procedures\",\n" +
                "    \"Condition\": \"Limitations\",\n" +
                "    \"Subject\": \"Instrument approach procedure\",\n" +
                "    \"Modifier\": \"Limited to\",\n" +
                "    \"message\": \"CENOR PROCEDURES RESTRICTIONS IN FORCE AND USE OF PROCEDURES\\nARE AUTHORIZED FOR NORWEGIAN MILITARY AIRCRAFT ONLY\\nCREATED: 21 Sep 2020 12:21:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"startdate\": \"2020-09-21T12:21:00.000Z\",\n" +
                "    \"enddate\": \"2020-12-08T12:00:00.000Z\",\n" +
                "    \"all\": \"A3412/20 NOTAMR A1826/20\\nQ) ENOR/QPILT/I /NBO/A /000/999/6716N01422E005\\nA) ENBO B) 2009211221 C) 2012081200 EST\\nE) CENOR PROCEDURES RESTRICTIONS IN FORCE AND USE OF PROCEDURES\\nARE AUTHORIZED FOR NORWEGIAN MILITARY AIRCRAFT ONLY\\nCREATED: 21 Sep 2020 12:21:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"location\": \"ENBO\",\n" +
                "    \"isICAO\": true,\n" +
                "    \"Created\": \"2020-09-21T12:21:00.000Z\",\n" +
                "    \"key\": \"A3412/20-ENBO\",\n" +
                "    \"type\": \"airport\",\n" +
                "    \"StateCode\": \"NOR\",\n" +
                "    \"StateName\": \"Norway\",\n" +
                "    \"criticality\": -1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"A2706/20\",\n" +
                "    \"entity\": \"OB\",\n" +
                "    \"status\": \"CE\",\n" +
                "    \"Qcode\": \"OBCE\",\n" +
                "    \"Area\": \"Other Information\",\n" +
                "    \"SubArea\": \"Other Information\",\n" +
                "    \"Condition\": \"Changes\",\n" +
                "    \"Subject\": \"Obstacle\",\n" +
                "    \"Modifier\": \"Erected\",\n" +
                "    \"message\": \"CONSTRUCTION CRANE ERECTED 1337M N OF THR 25 AT THE STORM.\\nMAX ALT 256FT AMSL\\nCREATED: 31 Jul 2020 11:23:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"startdate\": \"2020-07-31T11:22:00.000Z\",\n" +
                "    \"enddate\": \"2021-08-01T14:00:00.000Z\",\n" +
                "    \"all\": \"A2706/20 NOTAMN\\nQ) ENOR/QOBCE/IV/M  /A /000/999/6716N01422E005\\nA) ENBO B) 2007311122 C) 2108011400 EST\\nE) CONSTRUCTION CRANE ERECTED 1337M N OF THR 25 AT THE STORM.\\nMAX ALT 256FT AMSL\\nCREATED: 31 Jul 2020 11:23:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"location\": \"ENBO\",\n" +
                "    \"isICAO\": true,\n" +
                "    \"Created\": \"2020-07-31T11:23:00.000Z\",\n" +
                "    \"key\": \"A2706/20-ENBO\",\n" +
                "    \"type\": \"airport\",\n" +
                "    \"StateCode\": \"NOR\",\n" +
                "    \"StateName\": \"Norway\",\n" +
                "    \"criticality\": -1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"A2327/20\",\n" +
                "    \"entity\": \"NM\",\n" +
                "    \"status\": \"XX\",\n" +
                "    \"Qcode\": \"NMXX\",\n" +
                "    \"Area\": \"CNS\",\n" +
                "    \"SubArea\": \"Terminal and en-route navigation facilities\",\n" +
                "    \"Condition\": \"Other\",\n" +
                "    \"Subject\": \"VOR/DME\",\n" +
                "    \"Modifier\": \"Plain language\",\n" +
                "    \"message\": \"DVOR/DME BDO 117.550 MHZ/CH122Y DVOR NOT RELIABLE BETWEEN R300 \\nAND R345 DUE TO FLUCTUATING SIGNALS\\nCREATED: 26 Jun 2020 10:25:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"startdate\": \"2020-06-26T11:00:00.000Z\",\n" +
                "    \"enddate\": \"2020-12-20T11:00:00.000Z\",\n" +
                "    \"all\": \"A2327/20 NOTAMN\\nQ) ENOR/QNMXX/IV/BO /AE/000/999/6716N01422E025\\nA) ENBO B) 2006261100 C) 2012201100 EST\\nE) DVOR/DME BDO 117.550 MHZ/CH122Y DVOR NOT RELIABLE BETWEEN R300 \\nAND R345 DUE TO FLUCTUATING SIGNALS\\nCREATED: 26 Jun 2020 10:25:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"location\": \"ENBO\",\n" +
                "    \"isICAO\": true,\n" +
                "    \"Created\": \"2020-06-26T10:25:00.000Z\",\n" +
                "    \"key\": \"A2327/20-ENBO\",\n" +
                "    \"type\": \"airport\",\n" +
                "    \"StateCode\": \"NOR\",\n" +
                "    \"StateName\": \"Norway\",\n" +
                "    \"criticality\": -1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"A1419/20\",\n" +
                "    \"entity\": \"PK\",\n" +
                "    \"status\": \"XX\",\n" +
                "    \"Qcode\": \"PKXX\",\n" +
                "    \"Area\": \"ATM\",\n" +
                "    \"SubArea\": \"Air traffic procedures\",\n" +
                "    \"Condition\": \"Other\",\n" +
                "    \"Subject\": \"VFR approach procedure\",\n" +
                "    \"Modifier\": \"Plain language\",\n" +
                "    \"message\": \"AMEND MEHT PAPI RWY 25 TO READ 47 FT. REF ENBO 6-1 VISUAL APPROACH\\nCHART (VAC) DATED 06 DEC 2018\\nCREATED: 30 Apr 2020 07:41:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"startdate\": \"2020-04-30T07:40:00.000Z\",\n" +
                "    \"enddate\": \"2100-02-01T00:00:00.000Z\",\n" +
                "    \"all\": \"A1419/20 NOTAMN\\nQ) ENOR/QPKXX/V /NBO/A /000/999/6716N01422E005\\nA) ENBO B) 2004300740 C) PERM\\nE) AMEND MEHT PAPI RWY 25 TO READ 47 FT. REF ENBO 6-1 VISUAL APPROACH\\nCHART (VAC) DATED 06 DEC 2018\\nCREATED: 30 Apr 2020 07:41:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"location\": \"ENBO\",\n" +
                "    \"isICAO\": true,\n" +
                "    \"Created\": \"2020-04-30T07:41:00.000Z\",\n" +
                "    \"key\": \"A1419/20-ENBO\",\n" +
                "    \"type\": \"airport\",\n" +
                "    \"StateCode\": \"NOR\",\n" +
                "    \"StateName\": \"Norway\",\n" +
                "    \"criticality\": -1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"SWEN0598\",\n" +
                "    \"entity\": \"\",\n" +
                "    \"status\": \"\",\n" +
                "    \"Qcode\": \"\",\n" +
                "    \"Area\": \"\",\n" +
                "    \"SubArea\": \"\",\n" +
                "    \"Condition\": \"\",\n" +
                "    \"Subject\": \"\",\n" +
                "    \"Modifier\": \"\",\n" +
                "    \"message\": \"\",\n" +
                "    \"startdate\": \"2012-06-13T04:00:00.000Z\",\n" +
                "    \"enddate\": \"2006-11-30T00:00:00.000Z\",\n" +
                "    \"all\": \"SWEN0598 ENBO 12061152 \\n(SNOWTAM 0598\\nA) ENBO\\nB) 12061152 C) 07\\nF) 3/3/3 G) XX/XX/XX H) 5/5/5\\nN) ALPHA BRAVO CHARLIE DELTA ECHO FOXTROT GOLF HOTEL\\nINDIA JULIET MIKE QRA WHISKEY YANKEE/3\\nR) APRON EAST APRON WEST RWY EXTENSION WEST/3\\nT) CONTAMINATION/10/10/10/PERCENT.)\\nCREATED: 06 Dec 2020 11:56:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"location\": \"ENBO\",\n" +
                "    \"isICAO\": true,\n" +
                "    \"Created\": \"\",\n" +
                "    \"key\": \"SWEN0598-ENBO\",\n" +
                "    \"type\": \"airport\",\n" +
                "    \"StateCode\": \"NOR\",\n" +
                "    \"StateName\": \"Norway\",\n" +
                "    \"criticality\": -1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"SWEN0597\",\n" +
                "    \"entity\": \"\",\n" +
                "    \"status\": \"\",\n" +
                "    \"Qcode\": \"\",\n" +
                "    \"Area\": \"\",\n" +
                "    \"SubArea\": \"\",\n" +
                "    \"Condition\": \"\",\n" +
                "    \"Subject\": \"\",\n" +
                "    \"Modifier\": \"\",\n" +
                "    \"message\": \"\",\n" +
                "    \"startdate\": \"2012-06-10T02:00:00.000Z\",\n" +
                "    \"enddate\": \"2006-11-30T00:00:00.000Z\",\n" +
                "    \"all\": \"SWEN0597 ENBO 12060850 \\n(SNOWTAM 0597\\nA) ENBO\\nB) 12060850 C) 07\\nF) 3/3/3 G) XX/XX/XX H) 3/3/3\\nN) ALPHA BRAVO CHARLIE DELTA ECHO HOTEL QRA WHISKEY/3\\nYANKEE/2\\nR) APRON EAST APRON WEST RWY EXTENSION WEST/3\\nT) CONTAMINATION/100/100/100/PERCENT.)\\nCREATED: 06 Dec 2020 08:52:00 \\nSOURCE: EUECYIYN\",\n" +
                "    \"location\": \"ENBO\",\n" +
                "    \"isICAO\": true,\n" +
                "    \"Created\": \"\",\n" +
                "    \"key\": \"SWEN0597-ENBO\",\n" +
                "    \"type\": \"airport\",\n" +
                "    \"StateCode\": \"NOR\",\n" +
                "    \"StateName\": \"Norway\",\n" +
                "    \"criticality\": -1\n" +
                "  }\n" +
                "]";

        String data1 = "";
        try {
            URL url = new URL("https://applications.icao.int/dataservices/api/notams-realtime-list?api_key=fe13ea20-3ba6-11eb-aea9-9dfe8a09a8d1&format=json&criticality=1&locations=" + search);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();

                data1 = data1 + line;
            }
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return data1;
    }


    // if SnowTam exists return it in List else return null
    @RequiresApi(api = Build.VERSION_CODES.N)
    private ArrayList<String> searchSnowTam(String data) {
        ArrayList<String> result = new ArrayList<String>();
        String objects[] = null;

        objects = data.split("\\{");
        for (int i = 1; i < objects.length - 1; i++) {
            if (checkSnowTam(objects[i]) != null) {
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

        if (myResult != null) {
            for (int i = 2; i < myResult.size(); i++)
                textCode = textCode + myResult.get(i).substring(0, myResult.get(i).length() - 1) + "\n";//delete the \ that exist in the End

            Log.e("result", textCode);
            decodedSnowtam = fetchedDecoded.SnowtamDecoded(textCode);

            OriginalFragment.tv.setText(textCode);
            DecodedFragment.decodedTV.setText(decodedSnowtam);

        } else
            DecodedFragment.decodedTV.setText("No SnowTam");
        //  Log.d("Success",myResult.toString());

    }

    public void setCodeSnowTam(String codeSnowTam) {
        this.codeSnowTam = codeSnowTam;
    }

}


