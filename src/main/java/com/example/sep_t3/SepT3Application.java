package com.example.sep_t3;

import com.example.sep_t3.core.ModelFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


import java.io.IOException;
import java.util.Collections;

@SpringBootApplication (scanBasePackages= "com.example.sep_t3",exclude = {DataSourceAutoConfiguration.class })

public class SepT3Application {

    public static void main(String[] args) {
       // SpringApplication.run(SepT3Application.class, args);
        SpringApplication app = new SpringApplication(SepT3Application.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
        ModelFactory mf = new ModelFactory();
        Server server = null;
        try {
            server = new Server(mf.getAuthModel());
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
