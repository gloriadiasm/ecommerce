package com.unitri.comp.ecommerce.controller;

import com.unitri.comp.ecommerce.model.entity.Product;
import com.unitri.comp.ecommerce.model.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    final ProductService productService;

    ProductController() {
        this.productService = new ProductService();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productService.findById(id);
    }

    @PostMapping("/create")
    void create(@RequestBody Product product) {
        productService.create(product);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) throws SQLException {
        productService.deleteById(id);
    }

    @GetMapping
    List<Product> findAll() throws SQLException {
        return productService.findAll();
    }
}
