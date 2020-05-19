package com.unitri.comp.ecommerce.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart/items")
public class StockController {

    final StockService stockService;

    StockController() {
        this.stockService = new StockService();
    }

    @GetMapping("/{id}")
    public Stock findById(@PathVariable Long id) {

        return StockService.findById(id);
    }
    @PostMapping("/create")
    void create(@RequestBody Stock stock) {

        stockService.create(stock);
    }
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable  int id) {

        stockService.deleteById(id);
    }
    @GetMapping
    List<Stock> findAll() {

        return stockService.findAll();
    }
}
