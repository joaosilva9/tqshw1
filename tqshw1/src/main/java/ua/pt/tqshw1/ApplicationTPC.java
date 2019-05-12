/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pt.tqshw1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author abilio
 */
@SpringBootApplication(scanBasePackages={"ua.pt.tqshw1"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class ApplicationTPC {
    
    public static void main(String[] args) {
            SpringApplication.run(ApplicationTPC.class, args);
    }
    
}
