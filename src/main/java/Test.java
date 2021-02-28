import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    private static JSONArray stationsList;

    public static void initializeStationList(){
        try {
            String text = new Scanner(new URL("http://api.gios.gov.pl/pjp-api/rest/station/findAll").openStream()).useDelimiter("\\A").next();
            stationsList = new JSONArray(text);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public static ArrayList getJsonStationNameAndLocation(){
        ArrayList<String[]> arrayList=new ArrayList<>();
        stationsList.forEach(object->{
            JSONObject jsonObject=(JSONObject) object;
            arrayList.add(new String[]{(String) jsonObject.get("stationName"),(String) jsonObject.get("gegrLat"), (String) jsonObject.get("gegrLon")});
        });
        arrayList.sort((s1,s2)->String.CASE_INSENSITIVE_ORDER.compare(s1[0],s2[0]));
        return arrayList;
    }

    public void getMeasuringStationsId(){
        stationsList.forEach(object->{
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

    public static void main(String args[]){
        initializeStationList();
        ArrayList<String[]> arrayList=new ArrayList<>();
        for(int i=0;i<3;i++){
            JSONObject object= (JSONObject) stationsList.get(i);
            Integer tempId= (Integer) object.get("id");
            String tempUrl="http://api.gios.gov.pl/pjp-api/rest/station/sensors/"+tempId;
            try{
                String tempText=new Scanner(new URL(tempUrl).openStream()).useDelimiter("\\A").next();
                JSONArray tempJSONArray=new JSONArray(tempText);
                ArrayList<Integer> newTempArrayOfStrings=new ArrayList<>();
                tempJSONArray.forEach(tempObject->{
                    JSONObject tempJSONObject= (JSONObject) tempObject;
                    Integer tempIdOfBench= (Integer) tempJSONObject.get("id");
                    newTempArrayOfStrings.add(tempIdOfBench);
                });
                String[] tempArrayOfString= (String[]) newTempArrayOfStrings.toArray();
                arrayList.add(tempArrayOfString);
            }catch (IOException exc){
                exc.printStackTrace();
            }
        }
        arrayList.forEach(System.out::println);

    }

}