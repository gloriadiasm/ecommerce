package com.unitri.comp.ecommerce.controller;


import com.unitri.comp.ecommerce.model.Service.StoreService;
import com.unitri.comp.ecommerce.model.entity.Store;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController("/store")
public class StoreController {

    StoreService storeService;

    StoreController() throws SQLException {
        this.storeService = new StoreService();
    }
    @GetMapping("store/id")
    public Store findById(@PathVariable int id) throws SQLException {
        return storeService.findById(id);
    }
    @GetMapping("store/name")
    public List<Store> findSold(@PathVariable String name) throws SQLException {
        return storeService.findStore(name);
    }
    @PostMapping("store/create")
    public Store create(@RequestBody Store store) throws SQLException {
        return storeService.create(store);
    }
    @PutMapping("store/update")
    public Store update(@RequestBody Store store) throws SQLException {
        return storeService.update(store);
    }
    @DeleteMapping("store/delete")
    public void delete(@RequestBody Store store) throws SQLException {
        storeService.delete(store);
    }
    @DeleteMapping("store/delete/id")
    public void deleteById(@PathVariable int id) throws SQLException {
        storeService.deleteById(id);
    }
    @GetMapping("store/select")
    public List<Store> findAll() throws SQLException {
        return storeService.findAll();
    }

}

