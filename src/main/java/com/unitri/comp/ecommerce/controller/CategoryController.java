package com.unitri.comp.ecommerce.controller;

import com.unitri.comp.ecommerce.model.entity.Category;
import com.unitri.comp.ecommerce.model.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    final CategoryService categoryService;

    public CategoryController() {
        this.categoryService = new CategoryService();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable int id) {

        return categoryService.findById(id);
    }

    @PostMapping("/create")
    void create(@RequestBody Category category) {

        categoryService.create(category);
    }
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable  int id) throws SQLException {

        categoryService.deleteById(id);
    }
    @GetMapping
    List<Category> findAll() throws SQLException {

        return categoryService.findAll();
    }
}
