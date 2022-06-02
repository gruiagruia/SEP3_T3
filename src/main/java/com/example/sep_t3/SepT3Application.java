package com.example.sep_t3;

import com.example.sep_t3.core.ModelFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Collections;

@SpringBootApplication (scanBasePackages= "com.example.sep_t3")

public class SepT3Application {

    public static void main(String[] args) {
       // SpringApplication.run(SepT3Application.class, args);
        SpringApplication app = new SpringApplication(SepT3Application.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
        ModelFactory mf = new ModelFactory();
        Server server = new Server(mf.getUserModel(), mf.getFlightModel(), mf.getTripModel());
        server.run();
    }
}
