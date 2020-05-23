package com.unitri.comp.ecommerce.controller;

import com.unitri.comp.ecommerce.model.entity.Store;
import com.unitri.comp.ecommerce.model.service.StoreService;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    StoreService storeService;

    StoreController() throws SQLException {
        this.storeService = new StoreService();
    }
    @GetMapping("/{id}")
    public Store findById(@PathVariable int id) {
        return storeService.findById(id);
    }
    @PostMapping
    public Store create(@RequestBody Store store) {
        return storeService.create(store);
    }
    @PutMapping
    public Store update(@RequestBody Store store) {
        return storeService.update(store);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        storeService.deleteById(id);
    }
    @GetMapping
    public List<Store> findAll() {
        return storeService.findAll();
    }

}

