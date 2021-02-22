import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    /*
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            URL url = new URL("http://api.gios.gov.pl/pjp-api/rest/station/findAll");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = "";
            while (null != (str = br.readLine())) {
                System.out.println(str);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }*/
    public static void main(String args[]){
        try {
            String text=new Scanner(new URL("http://api.gios.gov.pl/pjp-api/rest/station/findAll").openStream()).useDelimiter("\\A").next();
            JSONArray array = new JSONArray(text);
            System.out.println(((JSONObject)array.get(1)).get("id"));
        } catch (IOException exception){
            exception.printStackTrace();
        }

    }

}