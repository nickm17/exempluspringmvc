package com.siit.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)
public class ExempluspringmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExempluspringmvcApplication.class, args);
    }

//    @Bean
//    public Object unobiect(){
//        return new Object();
//    }
}
