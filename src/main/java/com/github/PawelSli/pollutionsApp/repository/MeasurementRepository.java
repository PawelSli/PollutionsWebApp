package com.github.PawelSli.pollutionsApp.repository;


import com.github.PawelSli.pollutionsApp.models.StationData;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

public class MeasurementRepository {
    private ArrayList<StationData> stationDataArrayList;
    private  JSONArray jsonArray;

    public MeasurementRepository(ArrayList<StationData> stationDataArrayList) {
        this.stationDataArrayList = stationDataArrayList;
    }

    public void getStationSpecs(){
        String text = null;
        try{
            text = new Scanner(new URL("http://api.gios.gov.pl/pjp-api/rest/station/findAll").openStream()).useDelimiter("\\A").next();
        }catch (IOException exc){
            exc.printStackTrace();
        }
        JSONArray jsonArrayOfNames=new JSONArray(text);
        jsonArrayOfNames.forEach(object->{
            JSONObject singleStationSpec=(JSONObject)object;
            StationData stationData=new StationData((Integer)singleStationSpec.get("id"),(String)singleStationSpec.get("stationName"),Double.parseDouble((String) singleStationSpec.get("gegrLat")),Double.parseDouble((String) singleStationSpec.get("gegrLon")));
            stationDataArrayList.add(stationData);
        });
        stationDataArrayList.sort(((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getName(),o2.getName())));
    }

    public void getStationPostsList(){
        stationDataArrayList.forEach(station->{
            station.setPostsList(new ArrayList<Integer>());
            String tempText = null;
            String tempUrl="http://api.gios.gov.pl/pjp-api/rest/station/sensors/"+station.getId();
            try{
                tempText=new Scanner(new URL(tempUrl).openStream()).useDelimiter("\\A").next();
            }catch (IOException exc){
                exc.printStackTrace();
            }
            JSONArray arrayOfPosts=new JSONArray(tempText);
            arrayOfPosts.forEach(stationPost->{
                JSONObject jsonStationPost= (JSONObject) stationPost;
                station.getPostsList().add((Integer) jsonStationPost.get("id"));
            });

        });
    }

    public void getAirComponentsValue(){
        stationDataArrayList.forEach(station->{
            station.getPostsList().forEach(post->{
                String tempText=null;
                String tempPostId=post.toString();
                String tempUrl="http://api.gios.gov.pl/pjp-api/rest/data/getData/"+tempPostId;
                try{
                    tempText=new Scanner(new URL(tempUrl).openStream()).useDelimiter("\\A").next();
                }catch (IOException exc){
                    exc.printStackTrace();
                }
                JSONObject postSpec=new JSONObject(tempText);
                String postKey= (String) postSpec.get("key");
                JSONArray postValues= (JSONArray) postSpec.get("values");
                if(((JSONObject) postValues.get(0)) != JSONObject.NULL){
                    switch (postKey){
                        case "PM10":
                            station.setPm10Value(((BigDecimal) ((JSONObject)postValues.get(0)).get("value")).doubleValue());
                            break;
                        case "PM25":
                            station.setPm25Value(((BigDecimal) ((JSONObject)postValues.get(0)).get("value")).doubleValue());
                            break;
                        case "O3":
                            station.setO3Value(((BigDecimal) ((JSONObject)postValues.get(0)).get("value")).doubleValue());
                            break;
                        case "C6H6":
                            station.setC6h6Value(((BigDecimal) ((JSONObject)postValues.get(0)).get("value")).doubleValue());
                            break;
                        case "CO":
                            station.setCoValue(((BigDecimal) ((JSONObject)postValues.get(0)).get("value")).doubleValue());
                            break;
                        case "NO2":
                            station.setNo2Value(((BigDecimal) ((JSONObject)postValues.get(0)).get("value")).doubleValue());
                            break;
                        case "SO2":
                            station.setSo2Value(((BigDecimal) ((JSONObject)postValues.get(0)).get("value")).doubleValue());
                            break;
                    }
                }

            });
        });
    }

    public static void main(String args[]){

        MeasurementRepository measurementRepository=new MeasurementRepository(new ArrayList<>());
        measurementRepository.getStationSpecs();
        measurementRepository.getStationPostsList();
        measurementRepository.getAirComponentsValue();

        measurementRepository.stationDataArrayList.forEach(object->{
            System.out.println(object.getName());
            System.out.println(object.getId());
            System.out.println(object.getGeoLat());
            System.out.println(object.getGeoLon());
            System.out.println("Stanowiska pomiarowe");
            object.getPostsList().forEach(System.out::println);
            System.out.println("Wartosci gazow: ");
            System.out.println(object.getC6h6Value());
            System.out.println(object.getPm10Value());
            System.out.println(object.getPm25Value());
            System.out.println(object.getCoValue());
            System.out.println(object.getSo2Value());
            System.out.println(object.getNo2Value());
            System.out.println(object.getO3Value());
        });
    }

    public void initialize(){
        try {
            String text = new Scanner(new URL("http://api.gios.gov.pl/pjp-api/rest/station/findAll").openStream()).useDelimiter("\\A").next();
            jsonArray = new JSONArray(text);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public  ArrayList getJsonStationNameAndLocation(){
        ArrayList<String[]> arrayList=new ArrayList<>();
        jsonArray.forEach(object->{
            JSONObject jsonObject=(JSONObject) object;
            arrayList.add(new String[]{(String) jsonObject.get("stationName"),(String) jsonObject.get("gegrLat"), (String) jsonObject.get("gegrLon")});
        });
        arrayList.sort((s1,s2)->String.CASE_INSENSITIVE_ORDER.compare(s1[0],s2[0]));
        return arrayList;
    }

    public void getMeasuringStationsId(){
        jsonArray.forEach(object->{
            JSONObject jsonObject=(JSONObject) object;
            String tempId= (String) jsonObject.get("id");
            String tempUrl="http://api.gios.gov.pl/pjp-api/rest/station/sensors/"+tempId;
            try {
                String tempText=new Scanner(new URL(tempUrl).openStream()).useDelimiter("\\A").next();
                JSONArray tempJsonArray = new JSONArray(tempText);
                tempJsonArray.forEach(tempObject->{
                    JSONObject tempJsonObject=(JSONObject) tempObject;

                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
