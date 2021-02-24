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
    private  JSONArray jsonArray;

    public void initialize(){
        try {
            String text = new Scanner(new URL("http://api.gios.gov.pl/pjp-api/rest/station/findAll").openStream()).useDelimiter("\\A").next();
            jsonArray = new JSONArray(text);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public  ArrayList getJsonArrayNames(){
        ArrayList<String> arrayList=new ArrayList<>();
        jsonArray.forEach(object->{
            JSONObject jsonObject=(JSONObject) object;
            arrayList.add((String)jsonObject.get("stationName"));
        });
        Collections.sort(arrayList);
        return arrayList;
    }

    public ArrayList getGeographicLocation(){
        ArrayList<String[]> arrayList=new ArrayList<>();
        jsonArray.forEach(object->{
            JSONObject jsonObject=(JSONObject) object;
            arrayList.add(new String[]{(String) jsonObject.get("gegrLat"), (String) jsonObject.get("gegrLon")});
        });
        return arrayList;
    }
}
