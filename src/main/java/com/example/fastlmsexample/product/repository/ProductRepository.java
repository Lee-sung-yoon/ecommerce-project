package com.example.fastlmsexample.product.repository;

import com.example.fastlmsexample.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
