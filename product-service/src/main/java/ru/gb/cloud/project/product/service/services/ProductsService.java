package ru.gb.cloud.project.product.service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.cloud.project.product.service.model.Product;
import ru.gb.cloud.project.product.service.repositories.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public Optional<Product> findById(Long id) {
        return productsRepository.findById(id);
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Product saveOrUpdate(Product product) {
        return productsRepository.save(product);
    }

    public void deleteById(Long id) {
        productsRepository.deleteById(id);
    }

}
