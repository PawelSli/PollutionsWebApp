package com.github.PawelSli.pollutionsApp.repository;


import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MeasurementRepository {

    public  ArrayList getJsonArrayFromUrl(){
        ArrayList<String> arrayList=new ArrayList<>();
        try {
            String text = new Scanner(new URL("http://api.gios.gov.pl/pjp-api/rest/station/findAll").openStream()).useDelimiter("\\A").next();
            JSONArray array = new JSONArray(text);
            array.forEach(object->{
                JSONObject jsonObject=(JSONObject) object;
                arrayList.add((String)jsonObject.get("stationName"));
            });
            Collections.sort(arrayList);
        }catch (IOException exception){
            exception.printStackTrace();
        }
        return arrayList;
    }
}
