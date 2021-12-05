package ru.gb.lesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

@SpringBootApplication
@IntegrationComponentScan
public class Lesson8Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Lesson8Application.class, args);
        MessageChannel messageChannel = context.getBean(DirectChannel.class);

        Product product = new Product(1L, "New product");
        Message<Product> productMessage = MessageBuilder.withPayload(product)
                .setHeader("Tenant", "App-1")
                .build();

        messageChannel.send(productMessage);
    }

    @ServiceActivator(inputChannel = "inputChannelOne")
    public void inputChannelOne(@Payload Product payload, @Headers Map<String, Object> headers) {
        System.out.println("Payload: " + payload);
        System.out.println("Headers: ");
        headers.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));
    }

}
