package ru.gb.lesson8;

import org.springframework.integration.annotation.Gateway;

public interface ProductGateway {
    @Gateway(replyChannel = "errorChannel")
    Product getProduct();
}
