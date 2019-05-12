/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.tqshw1.apirest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.pt.tqshw1.services.CacheWithService;

/**
 *
 * @author abilio
 */

@RestController
@RequestMapping("/")
public class ApiRest {
    
    @Autowired
    CacheWithService service;
    
    @GetMapping(value="/weather_city/{city}")
    public List weather(@PathVariable("city") String city) {
        return service.getWeather(city);
    }
    
    @GetMapping(value="/weather_type/{idWeather}")
    public String typeWeather(@PathVariable("idWeather") String idWeather) {
        return service.getTypeWeather(Integer.parseInt(idWeather));
    }
    
}
