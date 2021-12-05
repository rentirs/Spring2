package ru.gb.lesson8;

public class ProductGatewayImpl implements ProductGateway {
    public Product getProduct() {
        return new Product(1L, "New Product");
    }
}
