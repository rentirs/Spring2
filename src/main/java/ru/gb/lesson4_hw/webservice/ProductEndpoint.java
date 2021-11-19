package ru.gb.lesson4_hw.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.gb.ru/lesson4_hw/webservice";

    private ProductRepository productRepository;

    @Autowired
    public ProductEndpoint(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProductResponse(@RequestPayload GetProductRequest request) {
        GetProductResponse response = new GetProductResponse();
        response.setProduct(productRepository.findProduct(request.getName()));
        return response;
    }
}
