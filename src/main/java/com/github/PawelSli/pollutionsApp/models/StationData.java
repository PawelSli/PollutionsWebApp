package com.github.PawelSli.pollutionsApp.models;

import java.util.ArrayList;

public class StationData {
    private Integer id;
    private String name;
    private Double geoLat;
    private Double geoLon;

    private ArrayList<Integer> postsList;

    private String indexLevelName;
    private String so2LevelName;
    private String no2LevelName;
    private String coLevelName;
    private String pm10LevelName;
    private String pm25LevelName;
    private String o3LevelName;
    private String c6h6LevelName;

    private Double so2Value;
    private Double no2Value;
    private Double coValue;
    private Double pm10Value;
    private Double pm25Value;
    private Double o3Value;
    private Double c6h6Value;

    public StationData(Integer id, String name, Double geoLat, Double geoLon) {
        this.id = id;
        this.name = name;
        this.geoLat = geoLat;
        this.geoLon = geoLon;
    }

    public Integer getId() {
        return id;
    }

    public Double getGeoLat() {
        return geoLat;
    }

    public Double getGeoLon() {
        return geoLon;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getPostsList() {
        return postsList;
    }

    public void setPostsList(ArrayList<Integer> postsList) {
        this.postsList = postsList;
    }

    public String getIndexLevelName() {
        return indexLevelName;
    }

    public void setIndexLevelName(String indexLevelName) {
        this.indexLevelName = indexLevelName;
    }

    public String getSo2LevelName() {
        return so2LevelName;
    }

    public void setSo2LevelName(String so2LevelName) {
        this.so2LevelName = so2LevelName;
    }

    public String getNo2LevelName() {
        return no2LevelName;
    }

    public void setNo2LevelName(String no2LevelName) {
        this.no2LevelName = no2LevelName;
    }

    public String getCoLevelName() {
        return coLevelName;
    }

    public void setCoLevelName(String coLevelName) {
        this.coLevelName = coLevelName;
    }

    public String getPm10LevelName() {
        return pm10LevelName;
    }

    public void setPm10LevelName(String pm10LevelName) {
        this.pm10LevelName = pm10LevelName;
    }

    public String getPm25LevelName() {
        return pm25LevelName;
    }

    public void setPm25LevelName(String pm25LevelName) {
        this.pm25LevelName = pm25LevelName;
    }

    public String getO3LevelName() {
        return o3LevelName;
    }

    public void setO3LevelName(String o3LevelName) {
        this.o3LevelName = o3LevelName;
    }

    public String getC6h6LevelName() {
        return c6h6LevelName;
    }

    public void setC6h6LevelName(String c6h6LevelName) {
        this.c6h6LevelName = c6h6LevelName;
    }

    public Double getSo2Value() {
        return so2Value;
    }

    public void setSo2Value(Double so2Value) {
        this.so2Value = so2Value;
    }

    public Double getNo2Value() {
        return no2Value;
    }

    public void setNo2Value(Double no2Value) {
        this.no2Value = no2Value;
    }

    public Double getCoValue() {
        return coValue;
    }

    public void setCoValue(Double coValue) {
        this.coValue = coValue;
    }

    public Double getPm10Value() {
        return pm10Value;
    }

    public void setPm10Value(Double pm10Value) {
        this.pm10Value = pm10Value;
    }

    public Double getPm25Value() {
        return pm25Value;
    }

    public void setPm25Value(Double pm25Value) {
        this.pm25Value = pm25Value;
    }

    public Double getO3Value() {
        return o3Value;
    }

    public void setO3Value(Double o3Value) {
        this.o3Value = o3Value;
    }

    public Double getC6h6Value() {
        return c6h6Value;
    }

    public void setC6h6Value(Double c6h6Value) {
        this.c6h6Value = c6h6Value;
    }
}
