/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.tqshw1.services;

import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
/**
 *
 * @author abilio
 */
public class IPMAServiceTest {
    
    public IPMAServiceTest() {
    }
    

    /**
     * Test of getWeather method, of class IPMAService.
     */
    @Test
    public void testGetWeather() {
        System.out.println("getWeather");
        String city = "Aveiro";
        IPMAService instance = new IPMAService();
        List result = instance.getWeather(city);
        Map obj =  (Map)result.get(0);
        assertEquals(9, obj.size());
        assertTrue(obj.containsKey("precipitaProb"));
        assertTrue(obj.containsKey("tMin"));
        assertTrue(obj.containsKey("tMax"));
        assertTrue(obj.containsKey("predWindDir"));
        assertTrue(obj.containsKey("idWeatherType"));
        assertTrue(obj.containsKey("classWindSpeed"));
        assertTrue(obj.containsKey("longitude"));
        assertTrue(obj.containsKey("forecastDate"));
        assertTrue(obj.containsKey("latitude"));
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCode method, of class IPMAService.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        String city = "Aveiro";
        IPMAService instance = new IPMAService();
        String expResult = "1010500";
        String result = instance.getCode(city);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTypeWeather method, of class IPMAService.
     */
    @Test
    public void testGetTypeWeather() {
        System.out.println("getTypeWeather");
        int idWeather = 1;
        IPMAService instance = new IPMAService();
        String expResult = "Céu limpo";
        String result = instance.getTypeWeather(idWeather);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
