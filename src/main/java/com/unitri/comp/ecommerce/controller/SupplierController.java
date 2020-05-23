package com.unitri.comp.ecommerce.controller;

import com.unitri.comp.ecommerce.model.entity.Supplier;
import com.unitri.comp.ecommerce.model.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    final SupplierService supplierService;

    SupplierController() {
        this.supplierService = new SupplierService();
    }

    @GetMapping("/{id}")
    public Supplier findById(@PathVariable int id) {
        return supplierService.findById(id);
    }

    @PostMapping
    void create(@RequestBody Supplier supplier) {
        supplierService.create(supplier);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id) throws SQLException {
        supplierService.deleteById(id);
    }

    @GetMapping
    List<Supplier> findAll() throws SQLException {
        return supplierService.findAll();
    }

    @PutMapping("/update")
    void update(@RequestBody Supplier supplier) {
        supplierService.update(supplier);
    }
}
