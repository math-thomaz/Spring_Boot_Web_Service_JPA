package com.maththomaz.webService.repositories;

import com.maththomaz.webService.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
