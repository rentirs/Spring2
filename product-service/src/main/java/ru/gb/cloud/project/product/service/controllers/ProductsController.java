package ru.gb.cloud.project.product.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.cloud.project.product.service.model.Product;
import ru.gb.cloud.project.product.service.exception.ResourceNotFoundException;
import ru.gb.cloud.project.product.service.services.ProductsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:12000")
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping
    public List<Product> findAll() {
        return  productsService.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doens't exist"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveNewProduct(@RequestBody Product product) {
        product.setId(null);
        return productsService.saveOrUpdate(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productsService.saveOrUpdate(product);
    }

    @DeleteMapping("/{id}")
    public void updateProduct(@PathVariable Long id) {
        productsService.deleteById(id);
    }

}
