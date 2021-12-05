package ru.gb.lesson8;

import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

public class MyServiceActivator {
    public void inputChannelOne(@Payload Product payload, @Headers Map<String, Object> headers) {
        System.out.println("Payload: " + payload);
        System.out.println("Headers: ");
        headers.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));
    }

}
