package com.unitri.comp.ecommerce.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart/items")
public class CartItemsController {

    final CartItemsService cartItemsService;

    CartItemsController() {
        this.cartItemsService = new CartItemsService();
    }

    @GetMapping("/{id}")
    public CartItems findById(@PathVariable Long id) {

        return cartItemsService.findById(id);
    }
    @PostMapping("/create")
    void create(@RequestBody CartItems cartItems) {

        cartItemsService.create(cartItems);
    }
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable  int id) {

        cartItemsService.deleteById(id);
    }
    @GetMapping
    List<CartItems> findAll() {

        return cartItemsService.findAll();
    }
}
