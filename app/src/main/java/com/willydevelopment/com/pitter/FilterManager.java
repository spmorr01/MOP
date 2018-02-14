package com.willydevelopment.com.pitter;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by JJ on 1/29/18.
 */

public class  FilterManager extends AsyncTask<Object, Object, StringBuffer> {

    @Override
    protected StringBuffer doInBackground(Object... params) {
        StringBuffer chaine = new StringBuffer("");
        try{
            URL url = new URL("http://pitter.azurewebsites.net/api/filter/getfilters");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("User-Agent", "");
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();

            InputStream inputStream = connection.getInputStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = rd.readLine()) != null) {
                chaine.append(line);
            }
        }  catch (Exception e) {
            e.printStackTrace();
            chaine  = null;
        }

        return chaine;
    }


    protected void onPostExecute(Void result) {
        String test = result.toString();
    }
}
