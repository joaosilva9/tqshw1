/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.tqshw1.apirest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import ua.pt.tqshw1.services.CacheWithService;

/**
 *
 * @author abilio
 */
@ExtendWith(MockitoExtension.class)
@WebMvcTest(value=ApiRest.class)
public class ApiRestTest {
  
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private CacheWithService service;
   
    @BeforeEach
    public void setUp() {
        List weather = new ArrayList<>();
        Map tool = new HashMap<>();
        tool.put("key1", "val1");
        tool.put("key2", "val2");
        weather.add(tool);
        weather.add(tool);
        String val = "ok";
        Mockito.when(service.getWeather("Camarao")).thenReturn(weather);
        Mockito.when(service.getTypeWeather(0)).thenReturn(val);
    }

    /**
     * Test of weather method, of class ApiRest.
     */
    @Test
    public void testWeather() throws Exception {
        System.out.println("weather");
        String city = "Camarao";
        mvc.perform(get("/weather_city/"+city)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0]", hasKey("key1")))
                .andExpect(jsonPath("$[0]", hasKey("key2")));
    }

    /**
     * Test of typeWeather method, of class ApiRest.
     */
    @Test
    public void testTypeWeather() throws Exception {
        System.out.println("typeWeather");
        int id_weather = 0;
        MvcResult result = mvc.perform(get("/weather_type/"+id_weather)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        
        String expResult = "ok";
        String content = result.getResponse().getContentAsString();
        assertEquals(expResult, content);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
