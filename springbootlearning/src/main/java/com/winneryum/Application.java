package com.winneryum;
 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;  

/** 
 * <p>User: Zhang Kaitao 
 * <p>Date: 13-12-22 
 * <p>Version: 1.0 
 */  
@Configuration  
//@ComponentScan  
@EnableAutoConfiguration  
public class Application {  
    public static void main(String[] args) {  
      System.out.println("11111111111111");
      SpringApplication.run(Application.class);  
    
    }  
}  