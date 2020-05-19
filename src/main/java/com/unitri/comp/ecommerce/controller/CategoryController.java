package com.unitri.comp.ecommerce.controller;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    final CategoryService categoryService;

    CategoryController() {
        this.categoryService = new CategoryService();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {

        return categoryService.findById(id);
    }
    @GetMapping("/client/")
    public Category findByClientId(@RequestBody @Valid Category category) {

        return categoryService.findById(category);
    }
    @PostMapping("/create")
    void create(@RequestBody Category category) {

        categoryService.create(category);
    }
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable  int id) {

        categoryService.deleteById(id);
    }
    @GetMapping
    List<Category> findAll() {

        return categoryService.findAll();
    }
}
