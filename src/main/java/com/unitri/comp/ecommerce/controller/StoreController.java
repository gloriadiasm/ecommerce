package com.unitri.comp.ecommerce.controller;


import com.unitri.comp.ecommerce.model.Service.StoreService;
import com.unitri.comp.ecommerce.model.entity.Store;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController("/store")
public class StoreController {

    StoreService storeService;

    StoreController(){
        this.storeService = new StoreService();
    }
    @GetMapping("/id")
    public Store findById(@PathVariable Long id) throws SQLException {
        return storeService.findById(id);
    }

}

