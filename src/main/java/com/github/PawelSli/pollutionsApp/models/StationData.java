package com.github.PawelSli.pollutionsApp.models;

public class StationData {
    private long id;
    private String name;
    private String airQuality;
    private String c6h6Level;
    private String pm10Level;
    private String no2Level;
    private String so2Level;
    private String pm25Level;
    private String o3Level;
    private String coLevel;

    public StationData(long id, String name, String airQuality, String c6h6Level, String pm10Level, String no2Level, String so2Level, String pm25Level, String o3Level, String coLevel) {
        this.id = id;
        this.name = name;
        this.airQuality = airQuality;
        this.c6h6Level = c6h6Level;
        this.pm10Level = pm10Level;
        this.no2Level = no2Level;
        this.so2Level = so2Level;
        this.pm25Level = pm25Level;
        this.o3Level = o3Level;
        this.coLevel = coLevel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(String airQuality) {
        this.airQuality = airQuality;
    }

    public String getC6h6Level() {
        return c6h6Level;
    }

    public void setC6h6Level(String c6h6Level) {
        this.c6h6Level = c6h6Level;
    }

    public String getPm10Level() {
        return pm10Level;
    }

    public void setPm10Level(String pm10Level) {
        this.pm10Level = pm10Level;
    }

    public String getNo2Level() {
        return no2Level;
    }

    public void setNo2Level(String no2Level) {
        this.no2Level = no2Level;
    }

    public String getSo2Level() {
        return so2Level;
    }

    public void setSo2Level(String so2Level) {
        this.so2Level = so2Level;
    }

    public String getPm25Level() {
        return pm25Level;
    }

    public void setPm25Level(String pm25Level) {
        this.pm25Level = pm25Level;
    }

    public String getO3Level() {
        return o3Level;
    }

    public void setO3Level(String o3Level) {
        this.o3Level = o3Level;
    }

    public String getCoLevel() {
        return coLevel;
    }

    public void setCoLevel(String coLevel) {
        this.coLevel = coLevel;
    }
}
