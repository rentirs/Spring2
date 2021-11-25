package ru.gb.cloud.project.product.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.cloud.project.product.service.model.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
}
