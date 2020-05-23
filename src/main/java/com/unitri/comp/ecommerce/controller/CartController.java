package com.unitri.comp.ecommerce.controller;

import com.unitri.comp.ecommerce.model.entity.Cart;
import com.unitri.comp.ecommerce.model.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    final CartService cartService;

    CartController() {
        this.cartService = new CartService();
    }

    @GetMapping("/{id}")
    public Cart findById(@PathVariable int id) {

        return cartService.findById(id);
    }

    @PostMapping("/create")
    void create(@RequestBody Cart cart) {

        cartService.create(cart);
    }
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable  int id) throws SQLException {

        cartService.deleteById(id);
    }
    @GetMapping
    List<Cart> findAll() throws SQLException {

        return cartService.findAll();
    }
}
