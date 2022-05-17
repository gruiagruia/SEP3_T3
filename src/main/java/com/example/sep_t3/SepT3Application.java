package com.example.sep_t3;

import com.example.sep_t3.core.ModelFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.io.IOException;
import java.util.Collections;

@SpringBootApplication(scanBasePackages= "com.example.sep_t3", exclude = {DataSourceAutoConfiguration.class })
@EntityScan(basePackages = {"com.example.sep_t3.entities"})
public class SepT3Application {

    public static void main(String[] args) {
        SpringApplication.run(SepT3Application.class, args);
        ModelFactory mf = new ModelFactory();
        Server server = new Server(mf.getUserModel(), mf.getFlightModel(), mf.getTripModel());
        server.run();
    }
}
