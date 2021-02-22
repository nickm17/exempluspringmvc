package com.siit.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ExempluspringmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExempluspringmvcApplication.class, args);
    }

}
