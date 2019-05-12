/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.tqshw1.services;

import java.util.LinkedHashMap;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;



/**
 *
 * @author abilio
 */
@Service
public class IPMAService {
    
    private final Client client = ClientBuilder.newClient();
    private static final String BaseURLWeather = "http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/";
    private static final String BaseURLCode = "http://api.ipma.pt/open-data/distrits-islands";
    private static final String BaseURLTypeWeather = "http://api.ipma.pt/open-data/weather-type-classe";
    public static final String FinalURL = ".json";
    
    public List getWeather(String code){
        JSONObject data = client
                                .target(BaseURLWeather+code+FinalURL)
                                .request(MediaType.APPLICATION_JSON)
                                .get(JSONObject.class);
        
        List dayPred = (List) data.get("data");
        return dayPred;
    }
    
    public String getCode(String city){
        JSONObject data = client
                                .target(BaseURLCode+FinalURL)
                                .request(MediaType.APPLICATION_JSON)
                                .get(JSONObject.class);
        List codes = (List) data.get("data");
        for (int i = 0; i< codes.size();i++){
            
            LinkedHashMap mapa = (LinkedHashMap) codes.get(i);
            if (mapa.get("local").equals(city)){
                return mapa.get("globalIdLocal")+"";
            }
            
        }
        return null;
    }

    public String getTypeWeather(int idWeather) {
        JSONObject data = client
                                .target(BaseURLTypeWeather+FinalURL)
                                .request(MediaType.APPLICATION_JSON)
                                .get(JSONObject.class);
        List codesWeather = (List) data.get("data");
        for (int i = 0; i< codesWeather.size();i++){
            
            LinkedHashMap mapa = (LinkedHashMap) codesWeather.get(i);
            if (mapa.get("idWeatherType").equals(idWeather)){
                return mapa.get("descIdWeatherTypePT")+"";
            }
            
        }
        
        return null;
    }

}
