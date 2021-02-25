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
import java.util.Comparator;
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

    public  ArrayList getJsonStationData(){
        ArrayList<String[]> arrayList=new ArrayList<>();
        jsonArray.forEach(object->{
            JSONObject jsonObject=(JSONObject) object;
            arrayList.add(new String[]{(String) jsonObject.get("stationName"),(String) jsonObject.get("gegrLat"), (String) jsonObject.get("gegrLon")});
        });
        arrayList.sort((s1,s2)->String.CASE_INSENSITIVE_ORDER.compare(s1[0],s2[0]));
        return arrayList;
    }

}
