/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.tqshw1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ua.pt.tqshw1.cache.Cache;
import org.springframework.stereotype.Service;

/**
 *
 * @author abilio
 */

@Service
public class CacheWithService {
    
    private Cache cache;
    
    @Autowired
    private IPMAService ipma;
    
    public CacheWithService(){
        this.cache = new Cache(15,15,15);
    }
    
    public Cache getCache(){
        return this.cache;
    }
    
    public List getWeather(String city){
        List key = new ArrayList(Arrays.asList(city));
        List predictions;
        if(this.cache.containsKey(key)){
            try {
                predictions = (List)this.cache.get(key);
            } catch (Exception ex) {
                Logger.getLogger(IPMAService.class.getName()).log(Level.SEVERE, null, ex);
                predictions = ipma.getWeather(city);
                this.cache.put(key, predictions);
            }
        }else{
            predictions = ipma.getWeather(city);
            this.cache.put(key, predictions);
        }
        return predictions;
    }
    
    public String getTypeWeather(int idWeather){
        return ipma.getTypeWeather(idWeather);
    }
    
}
