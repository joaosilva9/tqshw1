/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.tqshw1.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ua.pt.tqshw1.cache.Cache;

/**
 *
 * @author abilio
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CacheWithServiceTest {
    
    @TestConfiguration
    static class CacheWithServiceTestContextConfiguration {
  
        @Bean
        public CacheWithService weatherService() {
            return new CacheWithService();
        }
    }
 
    @InjectMocks
    private CacheWithService service;
 
    @Mock
    private IPMAService ipma;
    
    @BeforeEach
    public void setUp() {
        List weather = new ArrayList<>();
        Map obj = new HashMap();
        obj.put("key1", "val1");
        obj.put("key2", "val2");
        weather.add(obj);
        weather.add(obj);
        Mockito.when(ipma.getWeather("Camarao")).thenReturn(weather);
        Mockito.when(ipma.getTypeWeather(999)).thenReturn("Bom tempo");
        
    }
    
    /**
     * Test of getWeather method, of class CacheWithService.
     */
    @Test
    public void testGetWeather() {
        System.out.println("getWeather");
        assertEquals(ipma.getWeather("Camarao"), service.getWeather("Camarao"));
    }

    /**
     * Test of getTypeWeather method, of class CacheWithService.
     */
    @Test
    public void testGetTypeWeather() {
        System.out.println("getTypeWeather");
        assertEquals(ipma.getTypeWeather(999), service.getTypeWeather(999));

    }
    
}
