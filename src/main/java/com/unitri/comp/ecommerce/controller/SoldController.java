package com.unitri.comp.ecommerce.controller;

import com.unitri.comp.ecommerce.model.entity.Sold;
import com.unitri.comp.ecommerce.model.service.SoldService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/sold")
public class SoldController {

    final SoldService soldService;

    SoldController() {
        this.soldService = new SoldService();
    }
    @GetMapping("/{id}")
    public Sold findById(@PathVariable int id) {
        return soldService.findById(id);
    }
    @PostMapping("/create")
    public Sold create(@RequestBody Sold sold) {
        return soldService.create(sold);
    }
    @PutMapping("/update")
    public Sold update(@RequestBody Sold sold) {
        return soldService.update(sold);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) throws SQLException {
        soldService.deleteById(id);
    }
    @GetMapping
    public List<Sold> findAll() throws SQLException {
        return soldService.findAll();
    }
}
