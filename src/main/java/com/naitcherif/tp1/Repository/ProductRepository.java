package com.naitcherif.tp1.Repository;

import com.naitcherif.tp1.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.designation like %:x%")
    List<Product> findByDesignation(@Param("x") String mc);
}
