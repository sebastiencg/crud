package com.miantsebastien.crud.repository;

import com.miantsebastien.crud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
