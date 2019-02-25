package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlightsAppl {
    static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {

        ctx = SpringApplication.run(FlightsAppl.class, args);
    }
}
