/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.tqshw1.apirest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.pt.tqshw1.services.IPMAService;

/**
 *
 * @author abilio
 */

@RestController
@RequestMapping("/")
public class ApiRest {
    
    IPMAService service = new IPMAService();
    
    @GetMapping(value="/weather_city/{city}")
    public List weather(@PathVariable("city") String city) {
        String code = getCode(city);
        return service.getWeather(code);
    }
    
    @GetMapping(value="/weather_type/{idWeather}")
    public String typeWeather(@PathVariable("idWeather") String idWeather) {
        return service.getTypeWeather(Integer.parseInt(idWeather));
    }
    
    public String getCode(String city){
        return service.getCode(city);
    }
    
}
