package com.unitri.comp.ecommerce.controller;


import com.unitri.comp.ecommerce.model.Service.SoldService;
import com.unitri.comp.ecommerce.model.entity.Sold;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SoldController {

    SoldService soldService;

    SoldController() throws SQLException {
        this.soldService = new SoldService();
    }
    @GetMapping("/sold/select/{id}")
    public Sold findById(@PathVariable int id) throws SQLException {
        return soldService.findById(id);
    }
    @PostMapping("/sold/create")
    public Sold create(@RequestBody Sold sold) throws SQLException {
        return soldService.create(sold);
    }
    @PutMapping("/sold/update")
    public Sold update(@RequestBody Sold sold) throws SQLException {
        return soldService.update(sold);
    }
    @DeleteMapping("/sold/delete")
    public void delete(@RequestBody Sold sold) throws SQLException {
        soldService.delete(sold);
    }
    @DeleteMapping("/sold/delete/{id}")
    public void deleteById(@PathVariable int id) throws SQLException {
        soldService.deleteById(id);
    }
    @GetMapping("/sold/select")
    public List<Sold> findAll() throws SQLException {
        return soldService.findAll();
    }
}
