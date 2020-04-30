package com.unitri.comp.ecommerce.controller;

import com.unitri.comp.ecommerce.model.entity.Cart;
import com.unitri.comp.ecommerce.model.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController("/cart")
public class CartController {

    CartService cartService;

    CartController(){
        this.cartService = new CartService();
    }
    @GetMapping("/{id}")
    public Cart findById(@PathVariable Long id) throws SQLException {
        return cartService.findById(id);
    }
}
