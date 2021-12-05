package ru.gb.lesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication
@IntegrationComponentScan
@ImportResource("integration.xml")
public class Lesson8ServerGatewayApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Lesson8ServerGatewayApplication.class, args);
        ProductGateway productGateway = context.getBean(ProductGateway.class);
    }
}
