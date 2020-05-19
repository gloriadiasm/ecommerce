package com.unitri.comp.ecommerce.controller;

import com.unitri.comp.ecommerce.model.entity.Cart;
import com.unitri.comp.ecommerce.model.service.CartService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    final CartService cartService;

    CartController() {
        this.cartService = new CartService();
    }

    @GetMapping("/{id}")
    public Cart findById(@PathVariable Long id) {

        return cartService.findById(id);
    }
    @GetMapping("/client/")
    public Cart findByClientId(@RequestBody @Valid Cart cart) {

        return cartService.findByClientId(cart);
    }
    @PostMapping("/create")
    void create(@RequestBody Cart cart) {

        cartService.create(cart);
    }
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable  int id) {

        cartService.deleteById(id);
    }
    @GetMapping
    List<Cart> findAll() {

        return cartService.findAll();
    }
}
