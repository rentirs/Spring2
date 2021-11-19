package ru.gb.lesson4_hw.webservice;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductRepository {
    private static final Map<String, Product> products = new HashMap<>();

    @PostConstruct
    public void initData() {
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();

        product1.setName("Ватрушка");
        product1.setCategory(Category.ЕДА);
        product1.setDescription("Творог и тесто");
        product1.setPrice(25);

        product1.setName("Машинка");
        product1.setCategory(Category.ДЕТЯМ);
        product1.setDescription("Пластмасса и металл");
        product1.setPrice(500);

        product1.setName("Смартфон");
        product1.setCategory(Category.ЭЛЕКТРОНИКА);
        product1.setDescription("Поддержка 5G");
        product1.setPrice(68000);

        products.put("product1", product1);
        products.put("product2", product2);
        products.put("product3", product3);
    }

    public Product findProduct(String name) {
        return products.get(name);
    }
}
