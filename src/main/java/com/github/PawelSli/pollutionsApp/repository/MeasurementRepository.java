package com.github.PawelSli.pollutionsApp.repository;


import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class MeasurementRepository {

    public void getData(){

    }

    private static String readAll(Reader reader) throws IOException {
        StringBuilder stringBuilder=new StringBuilder();
        int i=0;
        while ((i = reader.read()) != -1) {
            stringBuilder.append((char) i);
        }
        return stringBuilder.toString();
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
