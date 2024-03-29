package com.arthurtalles.processoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication
public class ProcessoapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessoapiApplication.class, args);
    }

}
